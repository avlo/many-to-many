package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.repository.EscalationRepository;
import com.example.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class RequestService {
  private final RequestRepository requestRepository;

  @Autowired
  public RequestService(RequestRepository requestRepository) {
    this.requestRepository = requestRepository;
  }

  @Transactional
  public Request save(Request request) {
    return requestRepository.save(request);
  }

  public Optional<Request> findById(Integer id) {
    return requestRepository.findById(id);
  }
}
