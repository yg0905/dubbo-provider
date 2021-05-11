package com.sxkj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxkj.entities.sysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<sysMenu> {
}
