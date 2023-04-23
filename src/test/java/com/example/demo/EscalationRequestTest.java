package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.service.EscalationService;
import java.util.Optional;

import com.example.demo.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EscalationRequestTest {
  public static final String PRE_EXISTING_REQUEST = "PRE-EXISTING REQUEST";
  public static final String ESCALATION_WITH_REQUEST = "ESCALATION WITH REQUEST";
  @Autowired
  EscalationService escalationService;

  @Test
  void saveEscalationRequest() {
    Request preExistingRequest = new Request();
    preExistingRequest.setName(PRE_EXISTING_REQUEST);

    Escalation escalation = new Escalation();
    escalation.setName(ESCALATION_WITH_REQUEST);
    escalation.setRequest(preExistingRequest);

    Escalation saved = escalationService.save(escalation);
    Optional<Escalation> checkSaved = escalationService.findById(saved.getId());
    assertEquals(checkSaved.get().getName(), ESCALATION_WITH_REQUEST);
    assertEquals(checkSaved.get().getRequest().getName(), PRE_EXISTING_REQUEST);
  }
}
