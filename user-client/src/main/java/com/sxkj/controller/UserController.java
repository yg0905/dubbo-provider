package com.sxkj.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxkj.config.JsonResult;
import com.sxkj.entities.sysMenu;
import com.sxkj.entities.sysUser;
import com.sxkj.service.MenuService;
import com.sxkj.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("test")
    @SentinelResource(value = "test")
    public Object getUser(){

        System.out.println(menuService.test());
        redisTemplate.opsForValue().set("kk","123321");
        System.out.println(redisTemplate.opsForValue().get("kk"));
        List<sysUser> users = userService.users();
        List<sysUser> collect = users.stream().limit(10).collect(Collectors.toList());
        return JsonResult.success(0,"",collect);
    }
    @PostMapping("user")
    public JsonResult login(String username,String password){
       sysUser sysUser= userService.getOne(new QueryWrapper<sysUser>().eq("username",username));
       if (sysUser==null){
           return JsonResult.fail("账户不存在");
       }else if (!sysUser.getPassword().equals(DigestUtils.sha256Hex(password+sysUser.getSalt()))){
           return JsonResult.fail("密码错误");
       }
        return JsonResult.success();
    }
    @GetMapping("menu")
    public JsonResult menu(){
        List<sysMenu> menus = menuService.list(new QueryWrapper<sysMenu>().orderBy(true, true, "sort_number"));
        return JsonResult.success(getMenuTree(menus,-1L));
    }
    /**
     * 递归转化树形菜单
     */
    private List<Map<String, Object>> getMenuTree(List<sysMenu> menus, Long parentId) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < menus.size(); i++) {
            sysMenu temp = menus.get(i);
            if (parentId.intValue() == temp.getParentId().intValue()) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", temp.getMenuName());
                map.put("icon", temp.getMenuIcon());
                map.put("url", StrUtil.isBlank(temp.getMenuUrl()) ? "javascript:;" : temp.getMenuUrl());
                map.put("subMenus", getMenuTree(menus, menus.get(i).getId()));
                list.add(map);
            }
        }
        return list;
    }
    @RequestMapping("payment/get/test")
    public Object getUser1(){
        redisTemplate.opsForValue().set("kk","123321");
        System.out.println(redisTemplate.opsForValue().get("kk"));
        List<sysUser> users = userService.users();
        List<sysUser> collect = users.stream().limit(10).collect(Collectors.toList());
        return JsonResult.success(0,"",collect);
    }
}
