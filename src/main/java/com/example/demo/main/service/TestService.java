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

//    TO REPRODUCE:
//    1. Comment @Transactional, build project, run it and access GET /test. Two records in TESTS should be present.
//    2. Remove comment (let it be @Transactional), build, run, GET /test. Two records are present, should be none.
//    3. Don't touch the code. Just build it again, run, GET /test. Now no record is present, as it should be.
    @Transactional
    public void testWrapper() {
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
        throw new RuntimeException();
    }
}
