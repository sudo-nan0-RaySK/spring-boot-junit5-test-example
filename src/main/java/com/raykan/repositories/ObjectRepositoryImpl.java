package com.raykan.repositories;

import com.raykan.beans.DBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ObjectRepositoryImpl implements ObjectRepository{

    private final MongoTemplate mongoTemplate;

    @Override
    public void deleteAllObjects() {
        mongoTemplate.remove(new Query(), DBObject.class);
    }

    @Override
    public List<DBObject> getAllObjects() {
        return mongoTemplate.findAll(DBObject.class);
    }

    @Override
    public void addDBObject(DBObject object) {
        mongoTemplate.save(object);
    }
}
