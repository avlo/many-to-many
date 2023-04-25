package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.entity.Escalationnick;
import com.example.demo.service.EscalationnickService;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

@SpringBootTest
class EscalationnickTest {
  @Autowired
  EscalationnickService escalationnickService;

  @Test
  void saveEscalation() {
    Escalationnick escalationNick = new Escalationnick();
    escalationNick.setName("SHOULD NOT SAVE!!!");
    /**
     * below should throw exception. should not be able to save escalation without request (either
     * new or pre-existing)
     */
    assertThrows(InvalidDataAccessApiUsageException.class, () -> escalationnickService.save(
        escalationNick));
  }

  @Test
  void getExistingEscalation() {
    Optional<Escalationnick> e1 = escalationnickService.findById(1);
    System.out.println("e1: " + e1.get().getName());
    assertEquals(e1.get().getName(), "ESCALATION 1");
  }

  @Test
  void getEscalationException() {
    Optional<Escalationnick> e1 = escalationnickService.findById(1);
    assertNotEquals(e1.get().getName(), "ESCALATION 2");
  }
}
