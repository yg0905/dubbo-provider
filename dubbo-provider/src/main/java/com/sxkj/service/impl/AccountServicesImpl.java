package com.sxkj.service.impl;

import com.sxkj.dao.AccountDao;
import com.sxkj.service.AccountsService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
@Service
public class AccountServicesImpl implements AccountsService {
    @Resource
    AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
