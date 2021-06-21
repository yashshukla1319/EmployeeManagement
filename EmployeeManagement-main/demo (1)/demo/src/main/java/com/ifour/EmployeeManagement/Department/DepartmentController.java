package com.ifour.EmployeeManagement.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    @RequestMapping(path = "/{id}")
    public List<Department> getDepartmentBydept_id(@PathVariable("id")Integer dept_id)
    {
        RestTemplate restTemplate = new RestTemplate();
        return departmentService.getDepartmentBydept_id(dept_id);
        /*List<EmployeeInDepartment> employeeInDept = Arrays.asList(new EmployeeInDepartment(1,"yash","angular",10000,101));
        return employeeInDept.stream().map(employee ->{
            EmployeeInDepartment employeeInDepartment = restTemplate.getForObject
                    ("http://localhost:8080/employee/"+employee.getDept_id(),EmployeeInDepartment.class);
            return new Department(employeeInDepartment.getId(),employeeInDepartment.getName(),employeeInDepartment.getDept(),employeeInDepartment.getSalary(),
                    employeeInDepartment.getDept_id());
        } )
                .collect(Collectors.toList());*/
    }


    @RequestMapping(path="/", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department)
    {
         departmentService.addDepartment(department);

        /*RestTemplate restTemplate = new RestTemplate();
        List<Employee> employees = Arrays.asList(new Employee(1,"yash","angular",10000,101));
        return (Stream<List<Employee>>) employees.stream().map(Employee ->{
            com.ifour.EmployeeManagement.Employee.Employee employee = restTemplate.getForObject
                    ("http://8080/employee/"+employees.getClass().getName(), com.ifour.EmployeeManagement.Employee.Employee.class);
            return new Employee(employee.getName(),employee.getDept(),employee.getSalary(),employee.getDept_id());
        } )
                .collect(Collectors.toList());*/

    }

    @RequestMapping(path = "/{delete}", method = RequestMethod.DELETE)
    public void deleteDepartment(@PathVariable("delete")Integer dept_id)
    {
        RestTemplate restTemplate = new RestTemplate();
        departmentService.deleteDepartment(dept_id);
    }


    @RequestMapping(path = "/{put}", method = RequestMethod.PUT)
    public void updateDepartment(@PathVariable("put")
                               @RequestParam(required = false) Integer dept_id,
                               @RequestParam(required = false) String dept_name)
    {
        departmentService.updateDepartment(dept_id,dept_name);
    }

    @RequestMapping(path = "/employee/add", method = RequestMethod.POST)
    public List<Department> addEmployeeInDepartment(EmployeeInDepartment employeeInDepartment)    //Integer employee_id
    {
        departmentService.addEmployeeInDepartment(employeeInDepartment);
        RestTemplate restTemplate = new RestTemplate();
        List<EmployeeInDepartment> employeeInDept = Arrays.asList(new EmployeeInDepartment(1,"yash","angular",10000,101));
        return employeeInDept.stream().map(employee ->{
            /*EmployeeInDepartment employeeInDepartment =*/ restTemplate.getForObject
                    ("http://localhost:8080/employee/"+employee.getDept_id(),EmployeeInDepartment.class);
            return new Department(employeeInDepartment.getId(),employeeInDepartment.getName(),employeeInDepartment.getDept(),employeeInDepartment.getSalary(),
                    employeeInDepartment.getDept_id());
        } )
                .collect(Collectors.toList());
        //departmentService.addEmployeeInDepartment(employee_id);
    }

    @RequestMapping(path ="/employee/remove", method = RequestMethod.DELETE)
    public void removeEmployeeFromDepartment(Integer employee_id)
    {
        RestTemplate restTemplate = new RestTemplate();
        departmentService.removeEmployeeFromDepartment(employee_id);
    }
}

