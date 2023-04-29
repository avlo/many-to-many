package com.example.demo.repository;

import com.example.demo.entity.Escalation;
import com.example.demo.entity.Request;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
  @Query("SELECT r FROM Request r WHERE r.requestId = :requestId")
  Optional<Request> findByRequestId(Integer requestId);
}
