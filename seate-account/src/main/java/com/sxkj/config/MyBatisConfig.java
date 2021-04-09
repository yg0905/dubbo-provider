package com.sxkj.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sxkj.dao")
public class MyBatisConfig {
}
