package com.ifour.EmployeeManagement.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @RequestMapping(path = "/{id}")
    public List<Employee> getEmployee()
    {
        return EmployeeService.getEmployee();
    }
    @PostMapping()
    public void addNewEmployee(@RequestBody Employee employee)
    {
        employeeService.addNewEmployee(employee);
    }
}
