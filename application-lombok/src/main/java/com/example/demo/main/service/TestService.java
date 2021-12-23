package com.example.demo.main.service;

import com.example.demo.main.entity.TestEntity;
import com.example.demo.main.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
  @Autowired
  private TestRepository testRepository;

  @Transactional
  public void testWrapperTransactional() {
    firstOperation();
    secondOperation();
  }

  public void testWrapperNonTransactional() {
    firstOperation();
    secondOperation();
  }

  public void firstOperation() {
    TestEntity t = new TestEntity();
    t.setCode("first");
    testRepository.save(t);
  }

  public void secondOperation() {
    TestEntity t = new TestEntity();
    t.setCode("second");
    testRepository.save(t);
    throw new RuntimeException("uh-oh");
  }
}