package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.entity.Escalationnick;
import com.example.demo.entity.Requestnick;
import com.example.demo.service.EscalationnickService;
import com.example.demo.service.RequestnickService;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewEscalationExistingRequestTest {
  public static final String EXISTING_REQUEST = "EXISTING REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationnickService escalationnickService;
  @Autowired
  RequestnickService requestnickService;

  @Test
  void saveNewEscalationExistingRequest() {
    Requestnick newRequestnick = new Requestnick();
    newRequestnick.setName(EXISTING_REQUEST);
    Requestnick existingRequestnick = requestnickService.save(newRequestnick);

    Escalationnick escalationNick = new Escalationnick();
    escalationNick.setName(NEW_ESCALATION_WITH + existingRequestnick.getName());
    escalationNick.setRequestnick(existingRequestnick);

    Escalationnick saved = escalationnickService.save(escalationNick);
    Optional<Escalationnick> checkSavedEscalation = escalationnickService.findById(saved.getId());
    assertEquals(checkSavedEscalation.get().getName(), NEW_ESCALATION_WITH + EXISTING_REQUEST);
    assertEquals(checkSavedEscalation.get().getRequestnick().getName(), EXISTING_REQUEST);
  }
}
