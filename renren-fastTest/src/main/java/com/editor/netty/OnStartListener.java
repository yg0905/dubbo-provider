package com.editor.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 项目初始化
 * @author wunaozai
 * @date 2018-05-24
 */
@Component
public class OnStartListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(OnStartListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        log.info("Run on Start Listener.");
    }

}