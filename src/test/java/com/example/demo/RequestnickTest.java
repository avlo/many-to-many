package com.example.demo;

import com.example.demo.entity.Requestnick;
import com.example.demo.service.RequestnickService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class RequestnickTest {
	@Autowired
	RequestnickService requestnickService;

	@Test
	void saveEscalation() {
		Requestnick requestNick = new Requestnick();
		requestNick.setName("REQUEST 777");
		requestnickService.save(requestNick);
	}

	@Test
	void getNewlySavedEscalation() {
		Requestnick requestNick = new Requestnick();
		requestNick.setName("REQUEST 666");
		Requestnick saved = requestnickService.save(requestNick);
		Optional<Requestnick> checkSaved = requestnickService.findById(saved.getId());
		assertEquals(checkSaved.get().getName(), "REQUEST 666");
	}

	@Test
	void getExistingRequest() {
		Optional<Requestnick> e1 = requestnickService.findById(1);
		System.out.println("e1: " + e1.get().getName());
		assertEquals(e1.get().getName(), "REQUEST 1");
	}

	@Test
	void getRequestException() {
		Optional<Requestnick> e1 = requestnickService.findById(1);
		assertNotEquals(e1.get().getName(), "REQUEST 2");
	}

}
