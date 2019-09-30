package com.qfedu.service.impl;

import com.qfedu.mapper.AccountMapper;
import com.qfedu.pojo.Account;
import com.qfedu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> getAccountAll() {
        return accountMapper.getAccountAll();
    }

    @Override
    public String zhuanZhang(int fromId, int toId, int money) {

        Account account =new Account();
        account.setId(fromId);
        account.setMoney(-money);

        int result01 =  accountMapper.updateAccount(account);


        account.setId(toId);
        account.setMoney(money);
        int result02 =  accountMapper.updateAccount(account);

        if(result01 > 0 && result02 >0){
            return "success";
        }
        return "fail";
    }
}
