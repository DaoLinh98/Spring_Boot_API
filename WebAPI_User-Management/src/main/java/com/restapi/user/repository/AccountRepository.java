package com.restapi.user.repository;


import com.restapi.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUserName(String userName);
    boolean existsByUserName(String userName);
}
