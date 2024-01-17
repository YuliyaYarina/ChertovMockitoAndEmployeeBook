package com.example.chertovmockitoandemployeebook.service;

import com.example.chertovmockitoandemployeebook.model.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Integer salary, Integer id);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String,Employee> allEmployee();
}
