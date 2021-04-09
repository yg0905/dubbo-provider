package com.sxkj.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class sysMenu extends BaseEntity<sysMenu> {
    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单url
     */
    private String menuUrl;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 排序号
     */
    private Integer sortNumber;

    /**
     * 对应权限
     */
    private String authority;

    /**
     * 层级
     */
    private Integer grade;

    /**
     * 树路径
     */
    private String treePath;
    @TableField(exist = false)
    private List<sysMenu> childNodes;}
