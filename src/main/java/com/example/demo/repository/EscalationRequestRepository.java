package com.example.demo.repository;

import com.example.demo.entity.EscalationRequest;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EscalationRequestRepository extends JpaRepository<EscalationRequest, Integer> {
  @Query("SELECT e FROM EscalationRequest e WHERE e.escalationId = :escalationId")
  Optional<Collection<EscalationRequest>> findByEscalationId(Integer escalationId);
}
