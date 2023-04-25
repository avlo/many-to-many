package com.example.demo;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.service.EscalationService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-dev.properties")
class NewEscalationNewRequestIT {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationService escalationService;

  @Test
  void newEscalationNewRequestIT() {
    Request newRequest = new Request();
    newRequest.setName(NEW_REQUEST);

    Escalation escalation = new Escalation();
    escalation.setName(NEW_ESCALATION_WITH + newRequest.getName());
    escalation.setRequest(newRequest);

    Escalation saved = escalationService.save(escalation);
    Optional<Escalation> checkSaved = escalationService.findById(saved.getId());
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("escalation: " + checkSaved.get().getName());
    System.out.println("request   : " + checkSaved.get().getRequest().getName());
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("XXXXXXXXXXXXXXXXX");
  }
}
