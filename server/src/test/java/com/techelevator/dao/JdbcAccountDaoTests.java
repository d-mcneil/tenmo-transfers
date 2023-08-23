package com.techelevator.dao;

import com.techelevator.tenmo.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class JdbcAccountDaoTests {

//    Account getAccountById(int accountId);
//    Account createAccount(Account account);
//    Account updateAccount(Account account);

    public static Account ACCOUNT_1;
    public static Account ACCOUNT_2;
    public static Account ACCOUNT_3;

    @Before
    public void createAccounts(){
        ACCOUNT_1.setAccountId(2221);
        ACCOUNT_1.setUserId(1111);
        ACCOUNT_1.setBalance(BigDecimal.valueOf(1111.11));

        ACCOUNT_2.setAccountId(2222);
        ACCOUNT_2.setUserId(1112);
        ACCOUNT_2.setBalance(BigDecimal.valueOf(1111.12));

        ACCOUNT_3.setAccountId(2223);
        ACCOUNT_3.setUserId(1113);
    }

    @Test
    public void

}
