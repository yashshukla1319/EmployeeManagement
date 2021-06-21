package com.ifour.EmployeeManagement.Department;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Configurable
public class DepartmentConfig {

    @Bean
    CommandLineRunner commandLineRunner (DepartmentRepository repository)
    {
        return args -> {
            Department devloper = new Department(101,"java",1,"dhairya","trainee");
            Department frontend = new Department(102,"angular",2,"hemanshu","trainee");
            Department backend = new Department(103,".net",3,"gaurav","engineer.jr");
            //Department devloper = new Department(4,101,"java","dhaval");
            //Department frontend = new Department(5,102,"angular","dhairya");
            //Department backend = new Department(6,103,".net","karan");
            repository.saveAll(List.of(devloper,frontend,backend));
        };
    }
    @Bean
    CommandLineRunner commandLineRunner (EmployeeInDepartmentRepository repository){
        return args -> {
            EmployeeInDepartment amit = new EmployeeInDepartment();
            EmployeeInDepartment hemanshu = new EmployeeInDepartment();
            EmployeeInDepartment gaurav = new EmployeeInDepartment();
            repository.saveAll(List.of(amit,hemanshu,gaurav));
        };
    }
}
