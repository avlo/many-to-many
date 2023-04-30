package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Request implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer requestId;
  private String name;
}
