package com.raykan.controllers;

import com.raykan.beans.HealthInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/public/health")
@RestController
public class HealthApiController {

  private final HealthInfo healthInfo;

  @GetMapping("/")
  public HealthInfo getHealthInfo() {
    return healthInfo.setUpSince(System.currentTimeMillis() - healthInfo.getStartedAt());
  }
}


