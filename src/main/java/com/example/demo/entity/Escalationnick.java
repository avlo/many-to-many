package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
//@Table(name = "escalationnick")
public class Escalationnick implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

//  @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, optional = false)
//  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
//@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
  @OneToOne(cascade = CascadeType.MERGE, optional = false)
  @JoinTable(name = "escalationnick_requestnick",
      joinColumns =
          { @JoinColumn(name = "escalationnick_id", referencedColumnName = "id") },
      inverseJoinColumns =
          { @JoinColumn(name = "requestnick_id", referencedColumnName = "id", nullable = false) })
  private Requestnick requestnick;

  String name;
}
