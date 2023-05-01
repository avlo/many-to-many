package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.service.EscalationRequestService;
import java.util.ArrayList;
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
  void getExistingEscalationRequestsTest() {
    Collection<Request> requests = escalationRequestService.getEscalationRequests(111);
    assertTrue(Integer.valueOf(requests.size()).equals(2));
    assertTrue(requests.stream().anyMatch(request -> request.getRequestId().equals(1)));
    assertTrue(requests.stream().anyMatch(request -> request.getName().equals("REQUEST 1")));
    assertTrue(requests.stream().anyMatch(request -> request.getRequestId().equals(11)));
    assertTrue(requests.stream().anyMatch(request -> request.getName().equals("REQUEST 11")));
  }

  @Test
  void saveNewEscalationRequestTest() {
    // TODO: cleanup below
    Escalation e = new Escalation();
    e.setEscalationId(555);
    e.setName("REQUEST 555");
    Request r = new Request();
    r.setRequestId(5);
    r.setName("REQUEST 5");
    escalationRequestService.save(e, r);
    assertTrue(escalationRequestService.getEscalations(e.getEscalationId()).get().stream().anyMatch(escalation -> escalation.getEscalationId().equals(555)));
    assertFalse(escalationRequestService.getEscalations(e.getEscalationId()).get().stream().anyMatch(escalation -> escalation.getEscalationId().equals(666)));
  }

  @Test
  void saveEscalationWithMultipleRequestsTest() {
    // TODO: cleanup below
    Escalation e = new Escalation();
    e.setEscalationId(777);
    e.setName("ESCALATION 777");

    Request r1 = new Request();
    r1.setRequestId(7);
    r1.setName("REQUEST 7");

    Request r2 = new Request();
    r2.setRequestId(77);
    r2.setName("REQUEST 77");

    Collection<Request> requests = new ArrayList<>();
    requests.add(r1);
    requests.add(r2);
    escalationRequestService.save(e, requests);

    assertTrue(escalationRequestService.getEscalationRequests(e.getEscalationId()).stream().anyMatch(request -> request.getRequestId().equals(7)));
    assertTrue(escalationRequestService.getEscalationRequests(e.getEscalationId()).stream().anyMatch(request -> request.getRequestId().equals(77)));
  }

  @Test
  void checkNewEscalationExistingRequestTest() {
    Escalation e = new Escalation();
    e.setEscalationId(888);
    e.setName("ESCALATION 888");

    Request r1 = new Request();
    r1.setRequestId(8);
    r1.setName("REQUEST 8");

    Request r2 = new Request();
    r2.setRequestId(88);
    r2.setName("REQUEST 88");

    Collection<Request> requests = new ArrayList<>();
    requests.add(r1);
    requests.add(r2);
    escalationRequestService.save(e, requests);

    assertTrue(escalationRequestService.getEscalationRequests(e.getEscalationId()).stream().anyMatch(request -> request.getRequestId().equals(8)));
    assertTrue(escalationRequestService.getEscalationRequests(e.getEscalationId()).stream().anyMatch(request -> request.getRequestId().equals(88)));

    Escalation e2 = new Escalation();
    e2.setEscalationId(999);
    e2.setName("ESCALATION 999");

    escalationRequestService.save(e2, requests);

    assertEquals(e2.getEscalationId(), 999);
    assertTrue(escalationRequestService.getEscalationRequests(e2.getEscalationId()).stream().anyMatch(request -> request.getRequestId().equals(8)));
    assertTrue(escalationRequestService.getEscalationRequests(e2.getEscalationId()).stream().anyMatch(request -> request.getRequestId().equals(88)));
  }

  @Test
  void checkNotSavePreexistingEscalationRequest() {
    assertThrows(IllegalArgumentException.class, null,
        "\n\n!!! NEEDS UNIT TEST !!!!\n\n");
  }
}
