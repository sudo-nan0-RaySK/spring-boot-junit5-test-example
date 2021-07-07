package com.raykan;

import com.raykan.beans.HealthInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@Slf4j
public class Application {

  @Value("${server.port}")
  private int PORT_NUMBER;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    log.info("Application context has initialized");
  }

  @Bean
  public HealthInfo getHealthInfo(){
    return new HealthInfo()
            .setPortInfo(PORT_NUMBER)
            .setStatus("UP")
            .setStartedAt(System.currentTimeMillis());
  }
}
