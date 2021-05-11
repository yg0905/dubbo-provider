package com.sxkj.service;

import com.sxkj.entities.Col;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Object tests(){
        Query query=new Query(Criteria.where("title").is("666"));
        Update update=new Update().set("title","123");
        return mongoTemplate.findAll( Col.class);
    }
    public Col insert(){
        Col col=new Col();
        col.setBy("123");
        col.setLikes("321");
        return mongoTemplate.save(col);
    }
}
