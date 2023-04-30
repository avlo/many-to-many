package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

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
    assertTrue(Integer.valueOf(escalations.get().size()).equals(1));
    assertTrue(escalations.get().stream().anyMatch(escalation -> escalation.getEscalationId().equals(111)));
    assertTrue(escalations.get().stream().anyMatch(escalation -> escalation.getName().equals("ESCALATION 111")));
  }

  @Test
  void getEscalationRequestsTest() {
    Collection<Request> requests = escalationRequestService.getEscalationRequests(111);
    assertTrue(Integer.valueOf(requests.size()).equals(2));
    assertTrue(requests.stream().anyMatch(request -> request.getRequestId().equals(1)));
    assertTrue(requests.stream().anyMatch(request -> request.getName().equals("REQUEST 1")));
    assertTrue(requests.stream().anyMatch(request -> request.getRequestId().equals(11)));
    assertTrue(requests.stream().anyMatch(request -> request.getName().equals("REQUEST 11")));
  }
}
