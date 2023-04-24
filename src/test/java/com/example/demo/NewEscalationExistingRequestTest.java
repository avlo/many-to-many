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
public class NewEscalationExistingRequestTest {
  public static final String EXISTING_REQUEST = "EXISTING REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationService escalationService;
  @Autowired
  RequestService requestService;

  @Test
  void saveNewEscalationExistingRequest() {
    Request newRequest = new Request();
    newRequest.setName(EXISTING_REQUEST);
    Request existingRequest = requestService.save(newRequest);

    Escalation escalation = new Escalation();
    escalation.setName(NEW_ESCALATION_WITH + existingRequest.getName());
    escalation.setRequest(existingRequest);

    Escalation saved = escalationService.save(escalation);
    Optional<Escalation> checkSavedEscalation = escalationService.findById(saved.getId());
    assertEquals(checkSavedEscalation.get().getName(), NEW_ESCALATION_WITH + EXISTING_REQUEST);
    assertEquals(checkSavedEscalation.get().getRequest().getName(), EXISTING_REQUEST);
  }
}
