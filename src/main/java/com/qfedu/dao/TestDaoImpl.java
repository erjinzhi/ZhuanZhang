package com.qfedu.dao;

import com.qfedu.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * spring和jdbcTemplate整合
 * 1、在你需要的地方通过@Autowired给JdbcTemplate注入值
 *       <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
 *         <property name="dataSource" ref="dataSource"/>
 *     </bean>
 *
 * 2、jdbcTemplate 还提供了一种
 *      我们编写的类可以继承 JdbcDaoSupport
 *     而这个类中已经维护了一个jdbcTemplate对象
 *     而该jdbcTemplate对象要想创建成功，要么直接赋值给它，要么给它赋值一个dataSource
 *
 */

@Repository
public class TestDaoImpl  implements TestDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> selectAccountAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }
}
