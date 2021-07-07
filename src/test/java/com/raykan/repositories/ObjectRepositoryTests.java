package com.raykan.repositories;

import com.raykan.beans.DBObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
public class ObjectRepositoryTests {

  @Autowired ObjectRepository objectRepository;

  @Test
  @DisplayName("Check if deleteAll and findAll works (basic DB init check).")
  public void basicCheck() {
    objectRepository.deleteAllObjects();
    assertEquals(0, objectRepository.getAllObjects().size());
  }

  @Nested
  @DisplayName("CRUD API check")
  class CRUDCheck {

    @BeforeEach
    @AfterEach
    public void cleanDatabase() {
      objectRepository.deleteAllObjects();
      log.info("Ran DB cleanup");
    }

    @Test
    @DisplayName("Check insertion")
    public void testInsert() {
      DBObject dbObject = new DBObject();
      objectRepository.addDBObject(dbObject);
      assertEquals(1, objectRepository.getAllObjects().size());
    }
  }
}
