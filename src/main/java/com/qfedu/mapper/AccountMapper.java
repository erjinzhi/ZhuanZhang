package com.qfedu.mapper;

import com.qfedu.pojo.Account;

import java.util.List;

public interface AccountMapper {
    List<Account> getAccountAll();

    int updateAccount(Account account);
}
