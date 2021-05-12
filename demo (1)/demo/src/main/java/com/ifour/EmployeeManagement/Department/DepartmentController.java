package com.ifour.EmployeeManagement.Department;

import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;

    @RequestMapping(path = "/{id}")
    public Optional<Department> getDepartmentBydept_id(@PathVariable("/id")int dept_id)
    {
        System.out.println("Get by Department Id: ");
        return departmentService.getDepartmentBydept_id(dept_id);
    }


    @RequestMapping(path="/{post}", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department)
    {
        departmentService.addDepartment(department);
    }

    @RequestMapping(path = "/{delete}", method = RequestMethod.DELETE)
    public void deleteDepartment(@PathVariable("delete")int dept_id)
    {
        departmentService.deleteDepartment(dept_id);
    }


    @RequestMapping(path = "/{put}", method = RequestMethod.PUT)
    public void updateDepartment(@PathVariable("put")
                               @RequestParam(required = false) int dept_id,
                               @RequestParam(required = false) String dept_name)
    {
        departmentService.updateDepartment(dept_id,dept_name);
    }
}
