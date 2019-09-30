package com.qfedu.dao;

import com.qfedu.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;



public class TestDaoImpl2 extends JdbcDaoSupport implements TestDao {


    @Override
    public List<Account> selectAccountAll() {
        return this.getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }
}
