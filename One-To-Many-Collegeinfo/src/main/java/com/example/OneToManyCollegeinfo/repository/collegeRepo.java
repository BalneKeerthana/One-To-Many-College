package com.example.OneToManyCollegeinfo.repository;

import com.example.OneToManyCollegeinfo.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface collegeRepo extends JpaRepository<College, Integer> {
    Optional<College> findByName(String name);
}
