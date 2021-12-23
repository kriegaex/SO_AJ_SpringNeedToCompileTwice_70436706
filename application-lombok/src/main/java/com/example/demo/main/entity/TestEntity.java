package com.example.demo.main.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TEST_ID")
  private Long id;

  @Column(name = "TEST_CODE")
  private String code;
}