package com.raykan.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("dbObject")
@Data
public class DBObject {
    @Id
    private String id = UUID.randomUUID().toString();
}
