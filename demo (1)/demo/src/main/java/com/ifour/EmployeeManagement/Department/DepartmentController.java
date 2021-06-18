package com.ifour.EmployeeManagement.Department;

import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {
    Employee employee = new Employee();
    @Autowired
    public DepartmentService departmentService;

    @RequestMapping(path = "/{id}")
    public List<Department> getDepartmentBydept_id(@PathVariable("id")Integer dept_id)
    {
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println("Get by Department Id: ");
        return departmentService.getDepartmentBydept_id(dept_id);
    }


    @RequestMapping(path="/", method = RequestMethod.POST)
    public Stream<List<Employee>> addDepartment(@RequestBody Department department)
    {
        departmentService.addDepartment(department);

        RestTemplate restTemplate = new RestTemplate();
        List<Employee> employees = Arrays.asList(new Employee(1,"yash","angular",10000,101));
        return (Stream<List<Employee>>) employees.stream().map(Employee ->{
            com.ifour.EmployeeManagement.Employee.Employee employee1 = restTemplate.getForObject
                    ("http://8080:"+employees.getClass().getName(), com.ifour.EmployeeManagement.Employee.Employee.class);
            return new Employee(employee.getName(),employee.getDept(),employee.getSalary(),employee.getDept_id());
        } )
                .collect(Collectors.toList());

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

   /* @RequestMapping(path = "/employee/add", method = RequestMethod.POST)
    public void addEmployeeInDepartment(Integer E_id)
    {
        departmentService.addEmployeeInDepartment(E_id);
        Employee employee = new Employee();
    }

    @RequestMapping(path ="/employee/remove", method = RequestMethod.DELETE)
    public void removeEmployeeFromDepartment(Integer E_id)
    {
        departmentService.removeEmployeeFromDepartment(E_id);
    }*/
}

