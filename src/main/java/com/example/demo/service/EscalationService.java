package com.example.demo.service;

import com.example.demo.entity.Escalation;
import com.example.demo.repository.EscalationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EscalationService {
    private final EscalationRepository escalationRepository;

    @Autowired
    public EscalationService(EscalationRepository escalationRepository) {
        this.escalationRepository = escalationRepository;
    }

    @Transactional
    public Escalation save(Escalation escalation) {
        return escalationRepository.save(escalation);
    }

    public Optional<Escalation> findById(Integer id) {
        return escalationRepository.findById(id);
    }
}
