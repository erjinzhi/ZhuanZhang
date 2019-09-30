package com.qfedu.service;

import com.qfedu.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccountAll();

    String zhuanZhang(int fromId, int toId, int money);
}
