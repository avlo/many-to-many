package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.EscalationRequest;
import com.example.demo.repository.EscalationRequestRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationRequestService {
  private final EscalationRequestRepository escalationRequestRepository;

  private final EscalationService escalationService;
  private final RequestService requestService;

  @Autowired
  public EscalationRequestService(EscalationRequestRepository escalationRequestRepository,
      EscalationService escalationService, RequestService requestService) {
    this.escalationRequestRepository = escalationRequestRepository;
    this.escalationService = escalationService;
    this.requestService = requestService;
  }

  private Optional<Collection<EscalationRequest>> getEscalationRequestRecords(Integer escalationId) {
    return escalationRequestRepository.findByEscalationId(escalationId);
  }

  public Optional<Collection<Escalation>> getEscalations(Integer escalationId) {
    return escalationService.findByEscalationId(escalationId);
  }
}
