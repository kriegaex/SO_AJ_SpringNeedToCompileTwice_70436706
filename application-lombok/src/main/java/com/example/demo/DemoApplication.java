package com.example.demo;

import com.example.demo.main.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {
    try (ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args)) {
      TestController testController = context.getBean(TestController.class);
      testController.testTransactional();
      testController.testNonTransactional();
    }
  }
}