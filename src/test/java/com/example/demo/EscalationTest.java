package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Escalation;
import com.example.demo.service.EscalationService;
import java.util.Collection;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

@SpringBootTest
class EscalationTest {
  @Autowired EscalationService escalationService;

  @Test
  void saveEscalation() {
    Escalation escalation = new Escalation();
    escalation.setEscalationId(444);
    escalationService.save(escalation);
  }

  @Test
  void getExistingEscalation() {
    Optional<Collection<Escalation>> e1 = escalationService.findByEscalationId(111);
    assertTrue(e1.get().stream().anyMatch(x -> x.getEscalationId().equals(111)));
  }

  @Test
  void checkNoMatchPresent() {
    Optional<Collection<Escalation>> e1 = escalationService.findByEscalationId(999);
    assertTrue(!e1.get().stream().findAny().isPresent());
  }

  @Test
  void checkMatchNotPresent() {
    Optional<Collection<Escalation>> e1 = escalationService.findByEscalationId(999);
    assertFalse(e1.get().stream().findAny().isPresent());
  }
}
