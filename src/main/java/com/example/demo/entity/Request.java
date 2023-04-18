package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Request implements Serializable {

//    @ManyToMany
//    @JoinTable(
//            name = "request_escalation",
//            joinColumns = @JoinColumn(name = "request_id"),
//            inverseJoinColumns = @JoinColumn(name = "escalation_id"))
//    Set<Escalation> escalations;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    String name;
}
