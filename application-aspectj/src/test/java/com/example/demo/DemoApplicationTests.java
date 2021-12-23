package com.example.demo;

import com.example.demo.main.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
  @Autowired
  private TestController testController;

  @Test
  void testTransactional() {
    assertEquals(0, testController.testTransactional().getBody());
  }

  @Test
  void testNonTransactional() {
    assertEquals(2, testController.testNonTransactional().getBody());
  }
}