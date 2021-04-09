package com.sxkj.controller;

import com.sxkj.entity.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
public class msg {
    @Autowired
    private Source source;
    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String topic;

    @Value("${spring.application.name}")
    private String sender;
    @GetMapping(value = "sendMessage")
    public String send(MyMessage msg){
        msg.setContent("123");
        msg.setTitle("321");
        msg.setProduceTime(Timestamp.valueOf(LocalDateTime.now()));
        msg.setSender(sender);
        MessageBuilder builder = MessageBuilder.withPayload(msg);
        Message message = builder.build();
        source.output().send(message);
        return msg.toString()+" Send To Topic:"+topic;
    }
}
