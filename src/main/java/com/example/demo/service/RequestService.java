package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import com.example.demo.repository.RequestRepository;
import com.sun.istack.NotNull;
import java.util.Collection;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
  private final RequestRepository requestRepository;

  @Autowired
  public RequestService(RequestRepository requestRepository) {
    this.requestRepository = requestRepository;
  }

  @Transactional
  public Request save(@NotNull Request request) {
    return requestRepository.save(request);
  }

  public Optional<Request> findByRequestId(Integer requestId) {
    return requestRepository.findByRequestId(requestId);
  }
}
