package com.example.OneToManyCollegeinfo.service;

import com.example.OneToManyCollegeinfo.model.Department;
import com.example.OneToManyCollegeinfo.model.Faculty;
import com.example.OneToManyCollegeinfo.repository.departmentRepo;
import com.example.OneToManyCollegeinfo.repository.facultyRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private facultyRepo facultyRepo;
    @Autowired
    private departmentRepo drepo;
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepo.save(faculty);
    }
    public List<Faculty> getFacultiesByCollegeName(String collegeName) {
        return facultyRepo.findByCollegeName(collegeName);
    }
    public Faculty assignFacultyToDepartment(int facultyId, int departmentId) {
        Faculty faculty = facultyRepo.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        Department department = drepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        faculty.setDepartment(department);
        return facultyRepo.save(faculty);
    }
    public List<Faculty> getFacultiesByDepartmentName(String departmentName) {
        return facultyRepo.findByDepartmentName(departmentName);
    }
    public Faculty assignHodToDepartment(int facultyId, int departmentId) {
        Faculty faculty = facultyRepo.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        Department department = new Department();
        department.setDeptid(departmentId);

        faculty.setDepartment(department);
        return facultyRepo.save(faculty);
    }
}