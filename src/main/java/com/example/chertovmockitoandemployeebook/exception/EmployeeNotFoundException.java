package com.example.chertovmockitoandemployeebook.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super("Сотрудник не найден");
    }
}
