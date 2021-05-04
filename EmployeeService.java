package com.ifour.EmployeeManagement.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static List<Employee> getEmployee()
    {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        System.out.println(employee);
    }
}
