package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Escalation implements Serializable {
    private static final long serialVersionUID = -2147468513335906679L;
    //    @ManyToMany(mappedBy = "escalations")
//    Set<Request> requests;
//    @Id
//    @GeneratedValue(strategy = AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String name;
}
