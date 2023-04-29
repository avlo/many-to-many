package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.demo.entity.Request;
import com.example.demo.service.RequestService;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestServiceTest {
	@Autowired
	RequestService requestService;

	@Test
	void getExistingRequest() {
		Optional<Request> r = requestService.findByRequestId(1);
		// check optional non-empty
		assertTrue(r.isPresent());
		// check optional for match
		assertTrue(r.get().getRequestId().equals(1));
	}

	@Test
	void checkForNoEscalationMatch() {
		Optional<Request> r = requestService.findByRequestId(999);
		// check optional for no request
		assertThrows(NoSuchElementException.class, () -> r.get());
	}
}
