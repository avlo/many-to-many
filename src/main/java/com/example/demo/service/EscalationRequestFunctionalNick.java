package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationRequestFunctionalNick {
  public static final String PRE_EXISTING_REQUEST = "PRE-EXISTING REQUEST";
  public static final String ESCALATION_WITH_REQUEST = "ESCALATION WITH REQUEST";
  @Autowired
  public EscalationRequestFunctionalNick(
      EscalationService escalationService, RequestService requestService) {
    Request preExistingRequest = new Request();
    preExistingRequest.setName(PRE_EXISTING_REQUEST);
//    Request savedRequest = requestService.save(preExistingRequest);

    Escalation escalation = new Escalation();
    escalation.setName(ESCALATION_WITH_REQUEST);
    escalation.setRequest(preExistingRequest);

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
