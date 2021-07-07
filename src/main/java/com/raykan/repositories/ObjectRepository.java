package com.raykan.repositories;

import com.raykan.beans.DBObject;

import java.util.List;

public interface ObjectRepository {

  void deleteAllObjects();

  List<DBObject> getAllObjects();

  void addDBObject(DBObject object);
}
