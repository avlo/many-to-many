package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.service.EscalationService;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EscalationRequestTest {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationService escalationService;

  @Test
  void saveEscalationRequest() {
    Request newRequest = new Request();
    newRequest.setName(NEW_REQUEST);

    Escalation escalation = new Escalation();
    escalation.setName(NEW_ESCALATION_WITH + newRequest.getName());
    escalation.setRequest(newRequest);

    Escalation saved = escalationService.save(escalation);
    Optional<Escalation> checkSavedEscalation = escalationService.findById(saved.getId());
    assertEquals(checkSavedEscalation.get().getName(), NEW_ESCALATION_WITH + NEW_REQUEST);
    assertEquals(checkSavedEscalation.get().getRequest().getName(), NEW_REQUEST);
  }
}
