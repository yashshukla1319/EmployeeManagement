package com.ifour.EmployeeManagement.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;

    @RequestMapping(path = "/{id}")
    public List<Department> getDepartmentBydept_id(@PathVariable("id")Integer dept_id)
    {
        System.out.println("Get by Department Id: ");
        return departmentService.getDepartmentBydept_id(dept_id);
    }


    @RequestMapping(path="/", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department)
    {
        departmentService.addDepartment(department);
    }

    @RequestMapping(path = "/{delete}", method = RequestMethod.DELETE)
    public void deleteDepartment(@PathVariable("delete")Integer dept_id)
    {
        departmentService.deleteDepartment(dept_id);
    }


    @RequestMapping(path = "/{put}", method = RequestMethod.PUT)
    public void updateDepartment(@PathVariable("put")
                               @RequestParam(required = false) Integer dept_id,
                               @RequestParam(required = false) String dept_name)
    {
        departmentService.updateDepartment(dept_id,dept_name);
    }
}
