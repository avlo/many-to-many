package com.example.demo.repository;

import com.example.demo.entity.Requestnick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestnickRepository extends JpaRepository<Requestnick, Integer> { }
