package com.raykan.controllers;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class HealthApiControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getHealthInfo() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/public/health/"))
        .andDo(print())
            .andExpect(handler().handlerType(HealthApiController.class))
        .andExpect(content().string(containsString("UP")));
  }
}
