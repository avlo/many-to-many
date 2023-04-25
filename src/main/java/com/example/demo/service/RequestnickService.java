package com.example.demo.service;

import com.example.demo.entity.Requestnick;
import com.example.demo.repository.RequestnickRepository;
import com.sun.istack.NotNull;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestnickService {
  private final RequestnickRepository requestnickRepository;

  @Autowired
  public RequestnickService(RequestnickRepository requestnickRepository) {
    this.requestnickRepository = requestnickRepository;
  }

  @Transactional
  public Requestnick save(@NotNull Requestnick requestNick) {
    return requestnickRepository.save(requestNick);
  }

  public Optional<Requestnick> findById(Integer id) {
    return requestnickRepository.findById(id);
  }

  public Requestnick findByName(String name) {
    return requestnickRepository.findByName(name);
  }
}
