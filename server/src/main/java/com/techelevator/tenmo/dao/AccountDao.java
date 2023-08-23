package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

public interface AccountDao {
    Account getAccountById(int accountId);

    Account createAccount(Account account);

    Account updateAccount(Account account);

}