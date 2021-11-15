package com.sxkj.eventBus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventCotroller {
    @Autowired
    private EventHandler eventHandler;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/eventPost")
    public String eventPost() {
        LoginEvent loginEvent = new LoginEvent("22222222", "1111@qq.com", "Java实战1111");
        OrderEvent loginEvent1 = new OrderEvent("2222222211", "1111@qq1.com", "Java实战1111111");
        eventHandler.eventPost(loginEvent1);
        System.out.println("--------"+redisTemplate.opsForValue().get("asd"));
        return "ok";
    }

}
