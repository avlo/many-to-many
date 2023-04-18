package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.TABLE;

@Data
@Entity
public class Escalation {

//    @ManyToMany(mappedBy = "escalations")
//    Set<Request> requests;
//    @Id
//    @GeneratedValue(strategy = AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
}
