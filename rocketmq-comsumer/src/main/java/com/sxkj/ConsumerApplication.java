package com.sxkj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.time.LocalDateTime;

@SpringBootApplication
// 表示绑定配置文件中名称为input的消息通道
@EnableBinding({Sink.class})
public class ConsumerApplication {
    @StreamListener(value= Sink.INPUT)
    public void receive(String receiveMsg){
        System.out.println(LocalDateTime.now()+" received message:"+receiveMsg);
    }

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class,args);
    }
}
