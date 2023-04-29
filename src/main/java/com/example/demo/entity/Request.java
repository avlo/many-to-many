package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Request implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer requestId;
}
