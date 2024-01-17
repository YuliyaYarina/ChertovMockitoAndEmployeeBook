package com.example.chertovmockitoandemployeebook.exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
    }

    public EmployeeStorageIsFullException(String message) {
        super("Привышен лимит сотрудников");
    }
}
