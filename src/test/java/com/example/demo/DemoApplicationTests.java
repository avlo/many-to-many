package com.example.demo;

import com.example.demo.entity.Escalation;
import com.example.demo.service.EscalationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	EscalationService escalationService;

	@Test
	void saveEscalation() {
		Escalation escalation = new Escalation();
		escalation.setName("ESCALATION 666");
		escalationService.save(escalation);
	}

	@Test
	void getNewlySavedEscalation() {
		Escalation escalation = new Escalation();
		escalation.setName("ESCALATION 666");
		Escalation saved = escalationService.save(escalation);
		Optional<Escalation> checkSaved = escalationService.findById(saved.getId());
		assertEquals(checkSaved.get().getName(), "ESCALATION 666");
	}

	void saveEscalationRequest() {

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
