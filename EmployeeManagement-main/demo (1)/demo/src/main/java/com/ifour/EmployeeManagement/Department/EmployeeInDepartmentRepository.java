package com.ifour.EmployeeManagement.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface EmployeeInDepartmentRepository extends JpaRepository<EmployeeInDepartment,Integer> {

}
