package com.example.chertovmockitoandemployeebook.service;

import com.example.chertovmockitoandemployeebook.exception.EmployeeAlreadyAddedException;
import com.example.chertovmockitoandemployeebook.exception.EmployeeNotFoundException;
import com.example.chertovmockitoandemployeebook.exception.EmployeeStorageIsFullException;
import com.example.chertovmockitoandemployeebook.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.RequestEntity.put;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    private final int STORAGE_SIZE = 2;
    @PostConstruct
            public void initEmployee(){
        put("Ivan", "Petin", 1000, 1 );
        put("Ivan2", "Petin", 3000, 3 );
        put("Ivan3", "Petin", 600, 3 );
        put("Ivan4", "Petin", 1500, 1 );
        put("Ivan5", "Petin", 5000, 1 );
    };
    private final Map<String, Employee> employeeMap = new HashMap<>() ;

//    private String emplN(String firstName, String lastName, int salary, int id){
//        Employee employee = new Employee(
//                firstName,
//                lastName,
//                salary,
//                id
//        );
//        final String emplN = ""
//                + employee.getLastName() + " "
//                + employee.getLastName() + " "
//                + employee.getSalary() + " "
//                + employee.getId() + " ";
//        return emplN;
//    }
//    private String emplFL(String firstName, String lastName){
//        Employee employee = new Employee(
//                firstName,
//                lastName
//        );
//        final String emplFL = ""
//                + employee.getLastName() + " "
//                + employee.getLastName() + " ";
//        return emplFL;
//    }
@Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer id) {
//        validateInput(firstName, lastName);

        if (employeeMap.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        if (employeeMap.size() == STORAGE_SIZE) {
            throw new EmployeeStorageIsFullException("Привышен лимит сотрудников");
        }
        employeeMap.put(
                (firstName + lastName),
                new Employee(firstName, lastName, salary, id));

//        return emplN(firstName, lastName, salary, id) + "Добавлен";
    return employeeMap.get(firstName + lastName);

    }
@Override
    public Employee removeEmployee(String firstName, String lastName) {

//        validateInput(firstName, lastName);

        if (!employeeMap.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Удаляемого сотрудника и так нет");
        }
        employeeMap.remove(firstName + lastName);
    return employeeMap.get(firstName + lastName);
//        return emplFL(firstName, lastName) + "Удален";
    }
@Override
    public Employee findEmployee(String firstName, String lastName) {

//        validateInput(firstName, lastName);

    if (!employeeMap.containsKey(firstName + lastName)) {
        throw new EmployeeNotFoundException("Сoтрудник не найден");
    }
    return employeeMap.get(firstName + lastName);
}
 @Override
    public Map<String, Employee> allEmployee() {
        return employeeMap;
    }

//    private void validateInput(String firsName, String lastName) {
//        if(!(isAlpha(Integer.parseInt(firsName))&&isAlpha(Integer.parseInt(lastName)))){
//            throw new InvalidInputException("Не стандартное ФИО");
//        }
//    }
}
