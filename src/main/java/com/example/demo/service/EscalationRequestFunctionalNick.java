package com.example.demo.service;

import com.example.demo.entity.Escalation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EscalationRequestFunctionalNick {

    @Autowired
    public EscalationRequestFunctionalNick(EscalationService escalationService) {
        Optional<Escalation> e = escalationService.findById(1);
        System.out.println("44444444444444");
        System.out.println("44444444444444");
        System.out.println("e: " + e.get().getName());
        System.out.println("44444444444444");
        System.out.println("44444444444444");
    }

}
