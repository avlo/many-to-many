package com.example.demo;

import com.example.demo.entity.Escalationnick;
import com.example.demo.entity.Requestnick;
import com.example.demo.service.EscalationnickService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@TestPropertySource(locations = "classpath:application-dev.properties")
class NewEscalationNewRequestIT {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationnickService escalationNickService;

  @Test
  void newEscalationNewRequestIT() {
    Requestnick newRequestnick = new Requestnick();
    newRequestnick.setName(NEW_REQUEST);

    Escalationnick escalationNick = new Escalationnick();
    escalationNick.setName(NEW_ESCALATION_WITH + newRequestnick.getName());
    escalationNick.setRequestnick(newRequestnick);

    Escalationnick saved = escalationNickService.save(escalationNick);
    Optional<Escalationnick> checkSaved = escalationNickService.findById(saved.getId());
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("escalation: " + checkSaved.get().getName());
    System.out.println("request   : " + checkSaved.get().getRequestnick().getName());
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("XXXXXXXXXXXXXXXXX");
  }
}
