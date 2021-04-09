package com.sxkj.controller;

import com.sxkj.service.AccountsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {
    @Reference
    AccountsService accountsService;
    @RequestMapping("/hello")
    public String test(long userId, BigDecimal money){
        accountsService.decrease(userId,money);
        return "123";
    }
}
