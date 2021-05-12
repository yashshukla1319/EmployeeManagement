package com.ifour.EmployeeManagement.Department;

import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    public static DepartmentRepository departmentRepository;


    public void updateDepartment(int dept_id, String dept_name) {
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
        Optional<Department> getEmployeeByD_id =departmentRepository.find);
        if(getEmployeeByD_id == null)
        {
            throw new IllegalStateException("Employees with does not exist");
        }

    }

    public void deleteDepartment(int dept_id) {
        boolean exist = departmentRepository.existsById(dept_id);
        if(!exist)
        {
            throw new IllegalStateException("Department with Id: "+dept_id+"does not exists");
        }
        departmentRepository.deleteById(dept_id);
    }

    public Optional<Department> getDepartmentBydept_id(int dept_id) {
        return departmentRepository.findById(dept_id);

    }

}
