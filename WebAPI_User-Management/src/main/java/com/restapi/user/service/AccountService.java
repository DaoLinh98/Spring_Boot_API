package com.restapi.user.service;


import com.restapi.user.entity.Account;

public interface AccountService {
    Account findByUserName(final String userName);
    boolean exitsByUserName(final  String userName);
    Account saveOrUpdate(Account account);

}
