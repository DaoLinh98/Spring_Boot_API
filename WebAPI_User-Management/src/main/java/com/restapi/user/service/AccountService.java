package com.restapi.user.service;

import com.restapi.user.dao.AccountDAO;
import com.restapi.user.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public Account loadAccountByEmail(final  String email) {
        return this.accountDAO.loadAccountByEmail(email);
    }

    public boolean checkLogin (Account account) {
        return this.accountDAO.checkLogin(account);
    }
}
