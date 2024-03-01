package com.example.OneToManyCollegeinfo.repository;

import com.example.OneToManyCollegeinfo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface facultyRepo extends JpaRepository<Faculty, Integer> {
    List<Faculty> findByCollegeName(String collegeName);

    List<Faculty> findByDepartmentName(String departmentName);
}
