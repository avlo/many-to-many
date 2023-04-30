package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EscalationRequest implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer escalationId;
  private Integer requestId;

//  @EmbeddedId
//  private EscalationRequestPK id;
//
//  @MapsId("escalationId")
//  @ManyToOne
//  private Escalation escalation;
//
//  @MapsId("requestId")
//  @OneToOne
//  private Request request;
//
//  @Embeddable
//  @Data
//  public class EscalationRequestPK implements Serializable {
//    private static final long serialVersionUID = 1L;
//    private Long escalationId;
//    private Long requestId;
//  }
}
