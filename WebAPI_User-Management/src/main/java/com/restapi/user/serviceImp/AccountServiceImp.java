package com.restapi.user.serviceImp;


import com.restapi.user.entity.Account;
import com.restapi.user.repository.AccountRepository;
import com.restapi.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }

    @Override
    public boolean exitsByUserName(String userName) {
        return accountRepository.existsByUserName(userName);
    }

    @Override
    public Account saveOrUpdate(Account account) {
        return accountRepository.save(account);
    }
}