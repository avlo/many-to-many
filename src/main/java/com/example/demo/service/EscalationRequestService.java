package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.EscalationRequest;
import com.example.demo.entity.Request;
import com.example.demo.repository.EscalationRequestRepository;
//import com.google.common.base.Preconditions;
import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import javax.transaction.Transactional;
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

  public Collection<Request> getEscalationRequests(Integer escalationId) {
    Optional<Collection<EscalationRequest>> escalations = getEscalationRequestRecords(escalationId);

    // TODO: refactor all below lines to more efficient retrieval
    Collection<Request> requests = new ArrayList<>();

    for (EscalationRequest escalationRequest : escalations.get()) {
      requests.add(requestService.findByRequestId(escalationRequest.getRequestId()).get());
    }
    return requests;
  }

  @Transactional
  public void save(@NotNull Escalation escalation, @NotNull Collection<Request> requests) {
    for (Request request : requests) {
        save(escalation, request);
    }
  }

  @Transactional
  public EscalationRequest save(@NotNull Escalation escalation, @NotNull Request request) {
    //TODO: add Precondition for escalation null id or name
    //TODO: add Precondition for request null id or name
    requestService.save(request);
    escalationService.save(escalation);
    EscalationRequest er = new EscalationRequest();
    er.setEscalationId(escalation.getEscalationId());
    er.setRequestId(request.getRequestId());
    return escalationRequestRepository.save(er);
  }
}
