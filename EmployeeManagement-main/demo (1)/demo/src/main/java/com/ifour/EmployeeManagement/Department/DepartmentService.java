package com.ifour.EmployeeManagement.Department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {
    @Autowired
    public DepartmentRepository departmentRepository;
    @Autowired
    public EmployeeInDepartmentRepository employeeInDepartmentRepository;


    public void updateDepartment(Integer dept_id, String dept_name) {
        Department department = departmentRepository.findById(dept_id).orElseThrow(()->new IllegalStateException("Department with Id"+dept_id+"is not present"));

        if(!Objects.equals(department.getDept_id(),dept_id))
        {
            department.setDept_id(dept_id);
        }

        if(!Objects.equals(department.getDept_name(),dept_name))
        {
            department.setDept_name(dept_name);
        }

        departmentRepository.save(department);
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);

    }

    public void deleteDepartment(Integer dept_id) {
        boolean exist = departmentRepository.existsById(dept_id);
        if(!exist)
        {
            throw new IllegalStateException("Department with Id: "+dept_id+"does not exists");
        }
        departmentRepository.deleteById(dept_id);
    }

    public List<Department> getDepartmentBydept_id(Integer dept_id) {
        return departmentRepository.findAll();
    }

    public void addEmployeeInDepartment(EmployeeInDepartment employeeInDepartment) {
        //boolean exist = departmentRepository.existsById(employee_id);
        //departmentRepository.save(employeeInDepartment);
        employeeInDepartmentRepository.save(employeeInDepartment);
    }

    public void removeEmployeeFromDepartment(Integer employee_id) {
        boolean exist = departmentRepository.existsById(employee_id);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id does not exists in Department");
        }
        departmentRepository.deleteById(employee_id);
    }
}
