package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Escalation implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

//  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, optional = false)
//  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
//@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
  @OneToOne(cascade = CascadeType.MERGE, optional = false)
  @JoinTable(name = "escalation_request",
      joinColumns =
          { @JoinColumn(name = "escalation_id", referencedColumnName = "id") },
      inverseJoinColumns =
          { @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false) })
  private Request request;

  String name;
}
