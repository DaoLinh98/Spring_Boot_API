package com.restapi.user.dao;

import com.restapi.user.entity.Account;
import com.restapi.user.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDAO {
    private AccountRepository accountRepository;

    public Account loadAccountByEmail(final String email) {
        List<Account> accounts = accountRepository.findAll();
        Account ac = new Account();
        for (Account account : accounts) {
            if (account.getEmail().equals(email) ) {
                ac = accounts.get(account.getId() - 1);
                return ac;
            } else {
                return null;
            }
        }
        return ac;
    }

    public  boolean checkLogin(Account accountLogin) {
        boolean isAccount = false;
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            if (account.getEmail().equals(accountLogin.getEmail()) && account.getPassWord().equals(accountLogin.getPassWord())) {
                isAccount = true;
            } else {
                isAccount =  false;
            }
        }
        return isAccount;
    }

}