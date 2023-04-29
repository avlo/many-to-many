package com.example.demo.repository;

import com.example.demo.entity.Escalation;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EscalationRepository extends JpaRepository<Escalation, Integer> {
  @Query("SELECT e FROM Escalation e WHERE e.escalationId = :escalationId")
  Optional<Collection<Escalation>> findByEscalationId(Integer escalationId);

}
