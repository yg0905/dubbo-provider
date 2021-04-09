package com.sxkj.entities;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class sysUser extends Model<sysUser> {
    protected Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号
     */
    //private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 加盐
     */
    private String salt;
}
