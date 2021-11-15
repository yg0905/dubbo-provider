package com.sxkj.util;

import org.greenrobot.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {
	// 使用@Bean配置EventBus，以后直接注入使用即可
    @Bean
    public EventBus eventBus() {
        return EventBus.getDefault();
    }
}
