package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
//@Table(name = "requestnick")
public class Requestnick implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToOne(mappedBy = "requestnick", optional = true)
  Escalationnick escalationnick;

  String name;
}
