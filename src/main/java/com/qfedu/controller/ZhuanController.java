package com.qfedu.controller;

import com.qfedu.dao.TestDaoImpl2;
import com.qfedu.pojo.Account;
import com.qfedu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ZhuanController {



    @Autowired
    AccountService accountService;
    
    @Autowired
    TestDaoImpl2 testDao;

    @RequestMapping("/showPage")
    public String showPage(Model model){

        List<Account> accountList = testDao.selectAccountAll();
        // List<Account> accountList= accountService.getAccountAll();
       model.addAttribute("accountList",accountList);
        return "page.jsp";
    }


    @ResponseBody
    @RequestMapping("/zhuang/{fromId}/{toId}/{money}")
    public String zhuanZhang(@PathVariable("fromId") int fromId,@PathVariable("toId") int toId,@PathVariable("money") int money){

        System.out.println("修改一下");

        System.out.println("修改亮下");
        String result = accountService.zhuanZhang(fromId,toId,money);
        return result;
    }

    // http://localhost:
    @CrossOrigin  //表示该方法允许跨域访问
    @ResponseBody
    @RequestMapping("/hehe")
    public Account haha(){
        Account account =new Account();
        account.setName("张三");
        account.setMoney(1000);
        return account;
    }
}
