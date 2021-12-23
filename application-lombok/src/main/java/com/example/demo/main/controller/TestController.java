package com.example.demo.main.controller;

import com.example.demo.main.repository.TestRepository;
import com.example.demo.main.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
  @Autowired
  private TestService testService;
  @Autowired
  private TestRepository testRepository;

  @GetMapping("/testTransactional")
  public ResponseEntity<Integer> testTransactional() {
    try {
      testService.testWrapperTransactional();
    }
    catch (RuntimeException e) {
      log.warn(e + " -> " + testRepository.findAll());
    }
    return ResponseEntity.ok().body(testRepository.findAll().size());
  }

  @GetMapping("/testNonTransactional")
  public ResponseEntity<Integer> testNonTransactional() {
    try {
      testService.testWrapperNonTransactional();
    }
    catch (RuntimeException e) {
      log.warn(e + " -> " + testRepository.findAll());
    }
    return ResponseEntity.ok().body(testRepository.findAll().size());
  }
}