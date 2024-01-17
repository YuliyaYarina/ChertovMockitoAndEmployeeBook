package com.example.chertovmockitoandemployeebook.service;

import com.example.chertovmockitoandemployeebook.exception.EmployeeAlreadyAddedException;
import com.example.chertovmockitoandemployeebook.exception.EmployeeNotFoundException;
import com.example.chertovmockitoandemployeebook.exception.EmployeeStorageIsFullException;
import com.example.chertovmockitoandemployeebook.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeServiceimplTest {
    private final EmployeeServiceimpl employeeService = new EmployeeServiceimpl();
@Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenEmployeeIsAlreadyExisted() {
    Employee employee = new Employee("Ivan", "Petrov", 10000, 1);
    employeeService.addEmployee(
            employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getId()
    );

    Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> {
        employeeService.addEmployee(
                employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getId()
        );
    });
}


    @Test
    public void shouldCorrectlyFindEmployee(){
    Employee employee = new Employee("Ivan", "Petrov", 10000, 1);
    employeeService.addEmployee(
            employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getId()
    );
    Employee actualEmployee = employeeService.findEmployee(employee.getFirstName(), employee.getLastName());

    Assertions.assertEquals(employee, actualEmployee);
    }

}