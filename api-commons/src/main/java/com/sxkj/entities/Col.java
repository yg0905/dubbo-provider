package com.sxkj.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("col")
@Data
public class Col {
    @Id
    private String id;
    private String title;
    private String description;
    private String by;
    private String url;
    private String[] tags;
    private String likes;
}
