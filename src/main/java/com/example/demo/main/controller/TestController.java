package com.example.demo.main.controller;

import com.example.demo.main.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public ResponseEntity<Object> test() {
        testService.testWrapper();
        return ResponseEntity.ok().build();
    }
}