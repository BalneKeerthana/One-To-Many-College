package com.example.OneToManyCollegeinfo.controller;


import com.example.OneToManyCollegeinfo.model.Department;
import com.example.OneToManyCollegeinfo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/byCollegeName/{collegeName}")
    public ResponseEntity<List<Department>> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        List<Department> departments = departmentService.getDepartmentsByCollegeName(collegeName);
        return ResponseEntity.ok(departments);
    }
    @GetMapping("/{departmentId}/hodName")
    public ResponseEntity<String> getHodNameByDepartmentId(@PathVariable int departmentId) {
        String hodName = departmentService.getHodNameByDepartmentId(departmentId);
        return ResponseEntity.ok(hodName);
    }
}
