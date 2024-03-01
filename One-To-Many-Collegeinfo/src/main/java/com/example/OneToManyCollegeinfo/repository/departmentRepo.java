package com.example.OneToManyCollegeinfo.repository;

import com.example.OneToManyCollegeinfo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface departmentRepo extends JpaRepository<Department, Integer> {
    List<Department> findByCollegeName(String collegeName);

    //Optional<Department> findByName(String name);
}
