package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EntityRequest implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(cascade = CascadeType.MERGE, optional = false)
  @JoinTable(name = "escalation_request",
      joinColumns =
          { @JoinColumn(name = "entityrequest_id", referencedColumnName = "id") },
      inverseJoinColumns =
          { @JoinColumn(name = "escalation_id", referencedColumnName = "id", nullable = false) })
  private Request request;

  @ManyToMany(cascade = CascadeType.MERGE)
  @JoinTable(name = "escalation_request",
      joinColumns =
          { @JoinColumn(name = "entityrequest_id", referencedColumnName = "id") },
      inverseJoinColumns =
          { @JoinColumn(name = "entity_id", referencedColumnName = "id", nullable = false) })

  Escalation escalation;

}
