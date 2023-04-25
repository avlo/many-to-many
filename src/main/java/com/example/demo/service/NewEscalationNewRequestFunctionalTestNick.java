package com.example.demo.service;

import com.example.demo.entity.Escalationnick;
import com.example.demo.entity.Requestnick;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewEscalationNewRequestFunctionalTestNick {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";

  private final EscalationnickService escalationnickService;

  @Autowired
  public NewEscalationNewRequestFunctionalTestNick(EscalationnickService escalationnickService) {
    this.escalationnickService = escalationnickService;
    Requestnick newRequestnick = new Requestnick();
    newRequestnick.setName(NEW_REQUEST);

    Escalationnick escalationNick = new Escalationnick();
    escalationNick.setName(NEW_ESCALATION_WITH + newRequestnick.getName());
    escalationNick.setRequestnick(newRequestnick);

    Escalationnick saved = this.escalationnickService.save(escalationNick);
    Optional<Escalationnick> checkSaved = this.escalationnickService.findById(saved.getId());
    System.out.println("11111111111111111");
    System.out.println("11111111111111111");
    System.out.println("escalation: " + checkSaved.get().getName());
    System.out.println("request   : " + checkSaved.get().getRequestnick().getName());
    System.out.println("11111111111111111");
    System.out.println("11111111111111111");
  }
}
