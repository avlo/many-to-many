package com.example.demo.service;

import com.example.demo.entity.EscalationRequest;
import com.example.demo.repository.EscalationRequestRepository;
import com.sun.istack.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationRequestService {
  private final EscalationRequestRepository escalationRequestRepository;

  @Autowired
  public EscalationRequestService(EscalationRequestRepository escalationRequestRepository) {
    this.escalationRequestRepository = escalationRequestRepository;
  }

  public Collection<EscalationRequest> getEscalationRequests(@NotNull Integer escalationId) {
    return escalationRequestRepository.findByEscalationId(escalationId);
  }

  @Transactional
  public Collection<EscalationRequest> insert(@NotNull Collection<EscalationRequest> escalationRequests){
    return escalationRequests.stream().peek(escalationRequest -> insert(escalationRequest)).collect(
        Collectors.toList());
  }

  @Transactional
  public EscalationRequest insert(@NotNull EscalationRequest escalationRequest) {
    return escalationRequestRepository.save(escalationRequest);
  }

  @Transactional
  public Collection<EscalationRequest> update(@NotNull Collection<EscalationRequest> escalationRequests) {
    return escalationRequests.stream().peek(escalationRequest -> update(escalationRequest)).collect(
        Collectors.toList());
  }

  @Transactional
  public Integer update(@NotNull EscalationRequest escalationRequest) {
    return escalationRequestRepository.update(escalationRequest.getEscalationId(),escalationRequest.getRequestId());
  }
}
