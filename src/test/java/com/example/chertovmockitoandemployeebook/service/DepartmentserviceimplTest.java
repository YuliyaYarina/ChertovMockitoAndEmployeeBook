package com.example.chertovmockitoandemployeebook.service;

import com.example.chertovmockitoandemployeebook.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentserviceimplTest {

    @Mock
    private EmployeeServiceimpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private  final List<Employee> employees = new ArrayList<>() {{
        add(new Employee( "Ivan", "Ivanov1",  100_000, 1));
        add(new Employee( "Ivan", "Ivanov2",  200_000, 1));
        add(new Employee( "Ivan", "Ivanov3",  300_000, 1));

        add(new Employee( "Ivan", "Ivanov4",  60_000, 2));
        add(new Employee( "Ivan", "Ivanov5",  50_000, 2));

        add(new Employee( "Ivan", "Ivanov6",  160_000, 3));
    }};

    @Test
    public void shouldCorrectliFindEmployeeByDepartamentId() {
        int id = 1;

        List<Employee> expectedEmployees = new ArrayList<>() {{
            add(employees.get(2));
            add(employees.get(1));
            add(employees.get(0));
        }};

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.allEmployee()).thenReturn(employeeMap);

        List<Employee> actualEmployees = departmentService.allEmployeesByDepartment(id);

        Assertions.assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    public  void shouldCorrectlyCalculateSum() {
        int id = 1;
        int exceptedSum = 600_000;

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.allEmployee()).thenReturn(employeeMap);


        Integer salarySum = departmentService.getEmployeeSumSalaryByDepartment(id);


        Assertions.assertEquals(exceptedSum, salarySum);
    }

    @Test
    public  void shouldCorrectlyCalculateMin() {
        int id = 1;
        Employee exceptedEmployee = employees.get(0);

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.allEmployee()).thenReturn(employeeMap);


        Employee employee = departmentService.getEmployeeMinSalaryByDepartment(id);


        Assertions.assertEquals(exceptedEmployee, employee);
    }
    @Test
    public  void shouldCorrectlyCalculateMax() {
        int id = 1;
        Employee exceptedEmployee = employees.get(2);

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.allEmployee()).thenReturn(employeeMap);


        Employee employee = departmentService.getEmployeeMaxSalaryByDepartment(id);


        Assertions.assertEquals(exceptedEmployee, employee);
    }

    @Test
    public void shouldReturnNullWhereAreNoEmployeeInDepartament() {
        int id = 1;


        when(employeeService.allEmployee()).thenReturn(Collections.emptyMap());


        Employee employee = departmentService.getEmployeeMinSalaryByDepartment(id);


        Assertions.assertNull(employee);
    }

    @Test
    public void shouldCorrectlyGroupEmployeeBiDepartament() {

        Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }

        when(employeeService.allEmployee()).thenReturn(employeeMap);

        Map<Integer, List<Employee>> expectedMap = new HashMap<>() {{
            put(1, List.of(employees.get(2), employees.get(1), employees.get(0)));
            put(2, List.of(employees.get(3), employees.get(4)));
            put(3, List.of(employees.get(5)));
        }};

        Map<Integer, List<Employee>> actualMap = departmentService.findAll();

        Assertions.assertEquals(expectedMap,actualMap);
    }



}