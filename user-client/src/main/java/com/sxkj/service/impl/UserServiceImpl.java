package com.sxkj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxkj.entities.sysUser;
import com.sxkj.mapper.UserMapper;
import com.sxkj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, sysUser> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<sysUser> users() {
        return userMapper.selectList(null);
    }
}
