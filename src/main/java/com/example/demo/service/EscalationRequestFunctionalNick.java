package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationRequestFunctionalNick {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  public EscalationRequestFunctionalNick(EscalationService escalationService) {
    Request newRequest = new Request();
    newRequest.setName(NEW_REQUEST);

    Escalation escalation = new Escalation();
    escalation.setName(NEW_ESCALATION_WITH + newRequest.getName());
    escalation.setRequest(newRequest);

    Escalation saved = escalationService.save(escalation);
    Optional<Escalation> checkSaved = escalationService.findById(saved.getId());
    System.out.println("11111111111111111");
    System.out.println("11111111111111111");
    System.out.println("escalation: " + checkSaved.get().getName());
    System.out.println("request   : " + checkSaved.get().getRequest().getName());
    System.out.println("11111111111111111");
    System.out.println("11111111111111111");
  }
}
