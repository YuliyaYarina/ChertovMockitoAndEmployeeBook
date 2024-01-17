package com.example.chertovmockitoandemployeebook.exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super("Такой сотрудник уже ест");
    }
}
