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
    public void shouldThrowEmployeeStorageIsFullExceptionWhenEmployeeIsAlreadyExisted() {
    Employee employee1 = new Employee("Ivan1", "Petrov1", 10000, 1);
    Employee employee2 = new Employee("Ivan2", "Petrov2", 1000, 1);
    Employee employee3 = new Employee("Ivan3", "Petrov3", 100, 1);
    employeeService.addEmployee(
            employee1.getFirstName(), employee1.getLastName(), employee1.getSalary(), employee1.getId()
    );

    Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> {
        employeeService.addEmployee(
                employee2.getFirstName(), employee2.getLastName(), employee2.getSalary(), employee2.getId()
        );
        employeeService.addEmployee(
                employee3.getFirstName(), employee3.getLastName(), employee3.getSalary(), employee3.getId()
        );
    });
}
@Test
    public void checkingWhetheEmployeeBeenAdded() {
    Employee employee = new Employee("Ivan", "Petrov", 10000, 1);
    Employee actualEmployee = employeeService.addEmployee(
            employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getId()
    );
    Assertions.assertEquals(employee, actualEmployee);
}
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenEmployeeIsAlreadyNo() {
        Employee employee = new Employee("Ivan", "Petrov", 10000, 1);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.removeEmployee(
                    employee.getFirstName(), employee.getLastName()
            );
        });
    }

    @Test
    public void checkingIfTheEmployeeIsCurrentlyDeleted() {
        Employee employee = new Employee("Ivan", "Petrov", 10000, 1);
        employeeService.addEmployee(
                employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getId()
        );
        employeeService.removeEmployee(
                employee.getFirstName(), employee.getLastName()
        );
        Employee actualEmployee = employeeService.addEmployee(
                employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getId()
        );
        Assertions.assertEquals(employee, actualEmployee);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionIfEmployeeIsIsNotFound() {
        Employee employee = new Employee("Ivan", "Petrov", 10000, 1);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployee(
                    employee.getFirstName(), employee.getLastName()
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

    @Test
    public void checkinTheWithdrawalOfAllEmployees(){
        Employee employee = new Employee("Ivan", "Petrov", 10000, 1);

        Employee employee2 = new Employee("Ivan2", "Petrov2", 1000, 1);
        Employee employee3 = new Employee("Ivan3", "Petrov3", 100, 1);
        employeeService.allEmployee();

        Employee actualEmployee = employeeService.addEmployee(
                employee.getFirstName(), employee.getLastName(), employee.getSalary(),employee.getId()
        ); employeeService.addEmployee(
                employee2.getFirstName(), employee2.getLastName(), employee2.getSalary(),employee2.getId()
        );

        Assertions.assertEquals(employee, actualEmployee);
    }

}