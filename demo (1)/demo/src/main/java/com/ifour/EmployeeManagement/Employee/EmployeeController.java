package com.ifour.EmployeeManagement.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @RequestMapping(path = "/")
    public List<Employee> getEmployee()
    {
        System.out.println("Get ALl Called");
        return employeeService.getEmployee();
    }

    @RequestMapping(path = "/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id")Integer employeeId)
    {
        System.out.println("Get ID Called");
        System.out.println(employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @RequestMapping(path="/", method = RequestMethod.POST)
    public void addNewEmployee(@RequestBody Employee employee)
    {
        employeeService.addNewEmployee(employee);
    }

    @RequestMapping(path = "{employeeId}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable("employeeId")Integer employeeId)
    {
        employeeService.deleteEmployee(employeeId);
    }


    @RequestMapping(path = "{employeeId}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable("employeeId") Integer employeeId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String dept,
                               @RequestParam(required = false) Integer salary)
    {
        employeeService.updateEmployee(employeeId,name,dept,salary);
    }
}
