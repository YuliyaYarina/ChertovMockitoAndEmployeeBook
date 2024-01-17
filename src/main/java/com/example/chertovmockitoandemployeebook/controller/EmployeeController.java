package com.example.chertovmockitoandemployeebook.controller;

import com.example.chertovmockitoandemployeebook.model.Employee;
import com.example.chertovmockitoandemployeebook.service.EmployeeService;
import com.example.chertovmockitoandemployeebook.service.EmployeeServiceimpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeServiceimpl employeeServiceimpl;

    public EmployeeController(EmployeeServiceimpl employeeServiceimpl) {
        this.employeeServiceimpl = employeeServiceimpl;
    }

//    /employee/add?firstName=Ybhhv&lastName=Hgg&salary=77&id=1
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam Integer salary,
                              @RequestParam Integer id) {
        return employeeServiceimpl.addEmployee(firstName, lastName, salary, id);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        return employeeServiceimpl.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                               @RequestParam String lastName) {
        return employeeServiceimpl.findEmployee(firstName, lastName);

    }
    @GetMapping
    public Map<String,Employee> allEmployee() {
        return employeeServiceimpl.allEmployee() ;
    }
}

