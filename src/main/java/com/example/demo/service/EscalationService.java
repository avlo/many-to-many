package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.repository.EscalationRepository;
import com.sun.istack.NotNull;
import java.util.Collection;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationService {
  private final EscalationRepository escalationRepository;

  @Autowired
  public EscalationService(EscalationRepository escalationRepository) {
    this.escalationRepository = escalationRepository;
  }

  @Transactional
  public Escalation save(@NotNull Escalation escalation) {
    return escalationRepository.save(escalation);
  }

  public Optional<Collection<Escalation>> findByEscalationId(Integer escalationId) {
    return escalationRepository.findByEscalationId(escalationId);
  }
}
