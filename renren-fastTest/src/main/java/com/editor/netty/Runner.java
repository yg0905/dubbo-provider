package com.editor.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 项目启动时初始化资源<br>
 * 如 一些初始化操作，提前加载加密证书，初始化线程池等
 * @author wunaozai
 * @date 2018-05-24
 */
@Component
@Order(value = 1) //执行顺序
public class Runner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("The Runner start to Initialize.");
    }

}