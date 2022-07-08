package com.example.collection.service;

import com.example.collection.Employee;
import com.example.collection.exeption.EmloyeeNotFoundExeption;
import com.example.collection.exeption.EmployeeAlreadyAddedException;
import com.example.collection.exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();


    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if(employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if(employees.size()<LIMIT){
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee (String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (!employees.contains(employee)) {
            return employee;
        }
        throw new EmloyeeNotFoundExeption();

    }

    public Employee removeEmployee (String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (!employees.contains(employee)) {
            throw new EmloyeeNotFoundExeption();
        }
        employees.remove(employee);
        return employee;
    }

    public List<Employee>  getAll(){
        return new ArrayList<>(employees);
    }

    }



