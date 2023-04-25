package com.example.demo.repository;

import com.example.demo.entity.Requestnick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestnickRepository extends JpaRepository<Requestnick, Integer> {

  // below is kept here as good to know for future use, custom querties are avail
  // @Query("select r.id, r.name from Requestnick r where r.name in (:name)")

  // method impl automatically recognized by JPA since Requestnick has standard get/set
  Requestnick findByName(String name);
}
