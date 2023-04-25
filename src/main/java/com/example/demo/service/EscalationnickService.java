package com.example.demo.service;

import com.example.demo.entity.Escalationnick;
import com.example.demo.repository.EscalationnickRepository;
import com.sun.istack.NotNull;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscalationnickService {
  private final EscalationnickRepository escalationnickRepository;
  private final RequestnickService requestnickService;

  @Autowired
  public EscalationnickService(EscalationnickRepository escalationnickRepository, RequestnickService requestnickService) {
    this.escalationnickRepository = escalationnickRepository;
    this.requestnickService = requestnickService;
  }

  @Transactional
  public Escalationnick save(@NotNull Escalationnick escalationNick) {
    requestnickService.save(escalationNick.getRequestnick());
    return escalationnickRepository.save(escalationNick);
  }

  public Optional<Escalationnick> findById(Integer id) {
    return escalationnickRepository.findById(id);
  }
}
