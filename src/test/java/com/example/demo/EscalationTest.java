package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Escalation;
import com.example.demo.service.EscalationService;
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
    escalation.setName("SHOULD NOT SAVE!!!");
    /**
     * below should throw exception. should not be able to save escalation without request (either
     * new or pre-existing)
     */
    assertThrows(InvalidDataAccessApiUsageException.class, () -> escalationService.save(escalation));
  }

  @Test
  void getExistingEscalation() {
    Optional<Escalation> e1 = escalationService.findById(1);
    System.out.println("e1: " + e1.get().getName());
    assertEquals(e1.get().getName(), "ESCALATION 1");
  }

  @Test
  void getEscalationException() {
    Optional<Escalation> e1 = escalationService.findById(1);
    assertNotEquals(e1.get().getName(), "ESCALATION 2");
  }
}
