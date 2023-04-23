package com.example.demo;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.service.EscalationService;
import com.example.demo.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class RequestTest {
	@Autowired
	RequestService requestService;

	@Test
	void saveEscalation() {
		Request request = new Request();
		request.setName("REQUEST 777");
		requestService.save(request);
	}

	@Test
	void getNewlySavedEscalation() {
		Request request = new Request();
		request.setName("REQUEST 666");
		Request saved = requestService.save(request);
		Optional<Request> checkSaved = requestService.findById(saved.getId());
		assertEquals(checkSaved.get().getName(), "REQUEST 666");
	}

	@Test
	void getExistingRequest() {
		Optional<Request> e1 = requestService.findById(1);
		System.out.println("e1: " + e1.get().getName());
		assertEquals(e1.get().getName(), "REQUEST 1");
	}

	@Test
	void getRequestException() {
		Optional<Request> e1 = requestService.findById(1);
		assertNotEquals(e1.get().getName(), "REQUEST 2");
	}

}
