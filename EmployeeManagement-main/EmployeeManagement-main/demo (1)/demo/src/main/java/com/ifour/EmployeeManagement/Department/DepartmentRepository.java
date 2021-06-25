package com.ifour.EmployeeManagement.Department;

import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    public List<Employee> findEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);
}
