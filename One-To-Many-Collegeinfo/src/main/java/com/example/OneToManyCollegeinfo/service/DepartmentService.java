package com.example.OneToManyCollegeinfo.service;

import com.example.OneToManyCollegeinfo.model.Department;
import com.example.OneToManyCollegeinfo.repository.departmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private departmentRepo repo;
    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        return repo.findByCollegeName(collegeName);
    }
    public Department addDepartment(Department department) {
        return repo.save(department);
    }
    public String getHodNameByDepartmentId(int departmentId) {
        Department department = repo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return department.getHodName();
    }
}
