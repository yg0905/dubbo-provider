package com.sxkj.entity;



import java.io.Serializable;
import java.sql.Timestamp;

public class MyMessage implements Serializable {

    // 产生时间
    private Timestamp produceTime;
    // 发送人
    private String sender;
    // 标题
    private String title;
    // 内容
    private String content;

    public Timestamp getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Timestamp produceTime) {
        this.produceTime = produceTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "produceTime=" + produceTime +
                ", sender='" + sender + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}