package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcAccountDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class JdbcAccountDaoTests extends BaseDaoTests {

//    Account updateAccount(Account account);

    private JdbcAccountDao sut;

    public static Account ACCOUNT_1;
    public static Account ACCOUNT_2;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcAccountDao(jdbcTemplate);

    }

    @Before
    public void createAccounts() {
        ACCOUNT_1 = new Account();
        ACCOUNT_1.setAccountId(2001);
        ACCOUNT_1.setUserId(1001);
        ACCOUNT_1.setBalance(BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP));

        ACCOUNT_2 = new Account();
        ACCOUNT_2.setAccountId(2002);
        ACCOUNT_2.setUserId(1002);
        ACCOUNT_2.setBalance(BigDecimal.valueOf(1111.11));
    }

    @Test
    public void getAccountById_returns_correct_account_information() {
        Account account1 = sut.getAccountById(2001);
        assertAccountsMatch(ACCOUNT_1, account1);

        Account account2 = sut.getAccountById(2002);
        assertAccountsMatch(ACCOUNT_2, account2);
    }

    @Test
    public void getAccountById_returns_null_when_account_id_not_found(){
        Account nullAccount = sut.getAccountById(0);
        Assert.assertNull(nullAccount);
    }

    @Test
    public void created_account_has_expected_values_when_retrieved(){
        Account testAccount = new Account();
        testAccount.setUserId(1001);
        testAccount.setBalance(BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP));

        Account createdAccount = sut.createAccount(testAccount);
        int newId = createdAccount.getAccountId();
        Assert.assertTrue(newId > 1000);

        Account retrievedAccount = sut.getAccountById(newId);
        assertAccountsMatch(createdAccount, retrievedAccount);
    }


    private void assertAccountsMatch(Account expected, Account actual){
        Assert.assertEquals(expected.getAccountId(), actual.getAccountId());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.getBalance(), actual.getBalance());
    }
}
