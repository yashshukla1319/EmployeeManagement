package com.ifour.EmployeeManagement.Department;

import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
