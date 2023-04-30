package com.example.demo;

import com.example.demo.entity.Escalation;
import com.example.demo.service.EscalationRequestService;
import java.util.Collection;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EscalationRequestServiceTest {

  @Autowired
  EscalationRequestService escalationRequestService;

  @Test
  void getEscalationRequest() {
    Optional<Collection<Escalation>> escalations = escalationRequestService.getEscalations(111);
    System.out.println("1111111111111111");
    System.out.println("1111111111111111");
    System.out.println(escalations.get());
    System.out.println("1111111111111111");
    System.out.println("1111111111111111");
  }
}
