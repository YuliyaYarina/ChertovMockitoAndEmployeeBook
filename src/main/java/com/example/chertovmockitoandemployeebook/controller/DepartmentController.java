package com.example.chertovmockitoandemployeebook.controller;

import com.example.chertovmockitoandemployeebook.model.Employee;
import com.example.chertovmockitoandemployeebook.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/min")
    public Integer minSalaryByDepartment(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeMinSalaryByDepartment(id).getSalary();
    }

    @GetMapping("/{id}/salary/max")
    public Integer maxSalaryByDepartment(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeMaxSalaryByDepartment(id).getSalary();
    }
    @GetMapping("/{id}/salary/sum")
    public Integer sumSalaryByDepartment(@PathVariable("id") Integer id) {
        return departmentService.getEmployeeSumSalaryByDepartment(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> allEmployeesByDepartment(@PathVariable("id") Integer id) {
        return departmentService.allEmployeesByDepartment(id);
    }

    @GetMapping
    public Map<Integer, List<Employee>> findAll(){
        return departmentService.findAll();
    }
}

