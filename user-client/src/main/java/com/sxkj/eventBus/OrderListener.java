package com.sxkj.eventBus;

import cn.hutool.core.thread.ThreadUtil;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 事件监听
 */
@Component
public class OrderListener {
    // 异步方法
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void orderEmail(OrderEvent loginEvent) {
        ThreadUtil.sleep(3000L);
        System.out.println("接收到登录消息++发送邮件，OrderEventemail="
                + loginEvent.getEmail() + ", goodsName=" + loginEvent.getGoodsName()  +
                "== " + LocalDateTime.now());

    }
    // 异步方法
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void orderTel(LoginEvent loginEvent) {
        ThreadUtil.sleep(3000L);
        System.out.println("接收到登录消息++发送短信，telePhone="
                + loginEvent.getTelePhone() + ", goodsName=" + loginEvent.getGoodsName()
                + "== " + LocalDateTime.now());
    }
}
