package com.example.chertovmockitoandemployeebook.service;

import com.example.chertovmockitoandemployeebook.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee getEmployeeMinSalaryByDepartment(Integer id) {
        return employeeService.allEmployee().values().stream()
                .filter(employee -> employee.getId() == id)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public Employee getEmployeeMaxSalaryByDepartment(Integer id) {
        return employeeService.allEmployee().values().stream()
                .filter(employee -> employee.getId() == id)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public Integer getEmployeeSumSalaryByDepartment(Integer id) {
         return employeeService.allEmployee().values().stream()
                .filter(e -> e.getId() == id)
                 .map(Employee::getSalary)
                 .mapToInt(Integer::intValue)
                 .sum();
    }
    @Override
    public List<Employee> allEmployeesByDepartment(Integer id){
        return employeeService.allEmployee().values().stream()
                .filter(employee -> employee.getId() == id)
                .collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> findAll() {
        return employeeService.allEmployee().values().stream()
                .collect(Collectors.groupingBy(Employee::getId));
    }
}
