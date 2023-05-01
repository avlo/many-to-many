package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.EscalationRequest;
import com.example.demo.entity.Request;
import com.example.demo.service.EscalationRequestService;
import com.example.demo.service.EscalationService;
import com.example.demo.service.RequestService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;

@SpringBootTest
public class EscalationRequestServiceTest {

  @Autowired
  EscalationRequestService escalationRequestService;
  @Autowired
  EscalationService escalationService;
  @Autowired
  RequestService requestService;

  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  @Test
  void getEscalationRequestsTest() {
    Collection<EscalationRequest> escalationRequests = escalationRequestService.getEscalationRequests(111);
    assertTrue(Integer.valueOf(escalationRequests.size()).equals(2));
    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getEscalationId().equals(111)));
    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(1)));
    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(11)));
  }

  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  @Test
  void saveNewEscalationRequestTest() {
    // TODO: cleanup below
    Escalation e = new Escalation();
    e.setEscalationId(555);
    e.setName("REQUEST 555");
    Request r = new Request();
    r.setRequestId(5);
    r.setName("REQUEST 5");

    escalationService.save(e);
    requestService.save(r);

    EscalationRequest escalationRequestNew = new EscalationRequest();
    escalationRequestNew.setEscalationId(e.getEscalationId());
    escalationRequestNew.setRequestId(r.getRequestId());

    escalationRequestService.insert(escalationRequestNew);

    Collection<EscalationRequest> escalationRequests1 = escalationRequestService.getEscalationRequests(e.getEscalationId());

    assertTrue(escalationRequests1.stream().anyMatch(escalationRequest -> escalationRequest.getEscalationId().equals(555)));
    assertTrue(escalationRequests1.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(5)));

    assertFalse(escalationRequests1.stream().anyMatch(escalationRequest -> escalationRequest.getEscalationId().equals(666)));
  }

  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
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

    Collection<Integer> requestsIds = new ArrayList<>();
    requestsIds.add(r1.getRequestId());
    requestsIds.add(r2.getRequestId());

    escalationService.save(e);
    requestService.save(r1);
    requestService.save(r2);

    EscalationRequest escalationRequest1 = new EscalationRequest();
    escalationRequest1.setEscalationId(e.getEscalationId());
    escalationRequest1.setRequestId(r1.getRequestId());

    EscalationRequest escalationRequest2 = new EscalationRequest();
    escalationRequest2.setEscalationId(e.getEscalationId());
    escalationRequest2.setRequestId(r2.getRequestId());

    Collection<EscalationRequest> escalationRequests = escalationRequestService.insert(Arrays.asList(new EscalationRequest[]{escalationRequest1, escalationRequest2}));

    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(7)));
    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(77)));
  }

  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  @Test
  void newEscalationExistingRequestTest() {

    Collection<EscalationRequest> existingEscalationRequests = escalationRequestService.getEscalationRequests(111);

    existingEscalationRequests.stream().peek(escalationRequest -> escalationRequest.setEscalationId(444)).collect(Collectors.toList());

    Collection<EscalationRequest> escalationRequests = escalationRequestService.update(existingEscalationRequests);

    assertTrue(Integer.valueOf(escalationRequests.size()).equals(2));
    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(1)));
    assertTrue(escalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(11)));

  }

  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  @Test
  void newEscalationNewRequestTest() {

    EscalationRequest escalationRequest1 = new EscalationRequest();
    escalationRequest1.setEscalationId(888);
    escalationRequest1.setRequestId(8);

    EscalationRequest escalationRequest2 = new EscalationRequest();
    escalationRequest2.setEscalationId(888);
    escalationRequest2.setRequestId(88);

    Collection<EscalationRequest> insertEscalationRequests = escalationRequestService.insert(Arrays.asList(new EscalationRequest[]{escalationRequest1, escalationRequest2}));

    assertTrue(insertEscalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(8)));
    assertTrue(insertEscalationRequests.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(88)));

    escalationRequest1.setEscalationId(999);
    escalationRequest2.setEscalationId(999);

    Collection<EscalationRequest> updateEscalationRequest = escalationRequestService.update(Arrays.asList(new EscalationRequest[]{escalationRequest1, escalationRequest2}));

    assertTrue(updateEscalationRequest.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(8)));
    assertTrue(updateEscalationRequest.stream().anyMatch(escalationRequest -> escalationRequest.getRequestId().equals(88)));
  }

  @DirtiesContext(methodMode = MethodMode.AFTER_METHOD)
  @Test
  void checkNotSavePreexistingEscalationRequest() {
    assertThrows(IllegalArgumentException.class, null,
        "\n\n!!! NEEDS UNIT TEST for checkNotSavePreexistingEscalationRequest !!!!\n\n");
  }
}
