package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Escalation;
import com.example.demo.service.EscalationService;
import java.util.Collection;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EscalationServiceTest {
  @Autowired EscalationService escalationService;

  @Test
  @Order(1)
  void getExistingEscalation() {
    Collection<Escalation> e1 = escalationService.findByEscalationId(111);
    // check collection for match
    assertTrue(e1.stream().anyMatch(x -> x.getEscalationId().equals(111)));
    assertTrue(e1.stream().anyMatch(x -> x.getName().equals("ESCALATION 111")));
  }

  @Test
  @Order(2)
  void saveEscalation() {
    Escalation escalation = new Escalation();
    escalation.setEscalationId(555);
    escalation.setName("ESCALATION 555");
    escalationService.save(escalation);
  }

  @Test
  @Order(3)
  void getNewEscalation() {
    Collection<Escalation> e1 = escalationService.findByEscalationId(444);
    // check collection for match
    assertTrue(e1.stream().anyMatch(x -> x.getEscalationId().equals(444)));
    assertTrue(e1.stream().anyMatch(x -> x.getName().equals("ESCALATION 444")));
  }

  @Test
  void checkForNoEscalationMatch() {
    Collection<Escalation> e1 = escalationService.findByEscalationId(999);
    // check collection exists yet is empty
    assertTrue(!e1.stream().findAny().isPresent());
  }
}
