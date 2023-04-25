package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.entity.Escalationnick;
import com.example.demo.entity.Requestnick;
import com.example.demo.service.EscalationnickService;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewEscalationNewRequestTest {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationnickService escalationnickService;

  @Test
  void saveNewEscalationNewRequest() {
    Requestnick newRequestnick = new Requestnick();
    newRequestnick.setName(NEW_REQUEST);

    Escalationnick escalationNick = new Escalationnick();
    escalationNick.setName(NEW_ESCALATION_WITH + newRequestnick.getName());
    escalationNick.setRequestnick(newRequestnick);

    Escalationnick saved = escalationnickService.save(escalationNick);
    Optional<Escalationnick> checkSavedEscalation = escalationnickService.findById(saved.getId());
    assertEquals(checkSavedEscalation.get().getName(), NEW_ESCALATION_WITH + NEW_REQUEST);
    assertEquals(checkSavedEscalation.get().getRequestnick().getName(), NEW_REQUEST);
  }
}
