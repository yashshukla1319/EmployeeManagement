package com.ifour.EmployeeManagement.Employee;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Configurable
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository)
    {
        return args -> {
             Employee yash = new Employee("yash","java",15000);
            Employee hemanshu = new Employee("hemanshu","angular",15000);
            Employee ishan = new Employee("yash",".net",15000);


        };
        repository.saveAll(List.of(yash,hemanshu,ishan));
    }

}
