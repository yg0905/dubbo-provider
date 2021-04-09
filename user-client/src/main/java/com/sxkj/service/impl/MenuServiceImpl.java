package com.sxkj.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxkj.entities.sysMenu;
import com.sxkj.mapper.MenuMapper;
import com.sxkj.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl  extends ServiceImpl<MenuMapper, sysMenu> implements MenuService {
    @SentinelResource(value = "test")
    public String test(){
        return "SentinelResource";
    }
}

