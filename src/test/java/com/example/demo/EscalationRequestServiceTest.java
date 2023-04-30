package com.example.demo;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
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
  void getEscalationsTest() {
    Optional<Collection<Escalation>> escalations = escalationRequestService.getEscalations(111);
    System.out.println("1111111111111111");
    System.out.println("1111111111111111");
    System.out.println(escalations.get());
    System.out.println("1111111111111111");
    System.out.println("1111111111111111");
  }

  @Test
  void getEscalationRequestsTest() {
    Collection<Request> escalations = escalationRequestService.getEscalationRequests(111);
    System.out.println("222222222222222");
    System.out.println("222222222222222");
    System.out.println(escalations);
    System.out.println("222222222222222");
    System.out.println("222222222222222");
  }
}
