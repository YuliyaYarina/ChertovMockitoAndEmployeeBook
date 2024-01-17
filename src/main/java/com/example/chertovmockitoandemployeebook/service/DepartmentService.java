package com.example.chertovmockitoandemployeebook.service;

import com.example.chertovmockitoandemployeebook.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> allEmployeesByDepartment(Integer id);
    Integer getEmployeeSumSalaryByDepartment(Integer id);
    Employee getEmployeeMaxSalaryByDepartment(Integer id);
    Employee getEmployeeMinSalaryByDepartment(Integer id);

    Map<Integer, List<Employee>> findAll();
}
