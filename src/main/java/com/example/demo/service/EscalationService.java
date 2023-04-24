package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.repository.EscalationRepository;
import com.sun.istack.NotNull;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationService {
  private final EscalationRepository escalationRepository;
  private final RequestService requestService;

  @Autowired
  public EscalationService(EscalationRepository escalationRepository, RequestService requestService) {
    this.escalationRepository = escalationRepository;
    this.requestService = requestService;
  }

  @Transactional
  public Escalation save(@NotNull Escalation escalation) {
    requestService.save(escalation.getRequest());
    return escalationRepository.save(escalation);
  }

  public Optional<Escalation> findById(Integer id) {
    return escalationRepository.findById(id);
  }
}
