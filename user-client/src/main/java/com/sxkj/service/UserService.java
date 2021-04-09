package com.sxkj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sxkj.entities.sysUser;

import java.util.List;

public interface UserService extends IService<sysUser> {
    public List<sysUser> users();
}
