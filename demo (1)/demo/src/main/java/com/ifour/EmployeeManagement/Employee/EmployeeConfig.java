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
             Employee yash = new Employee("Yash","java",15000,1);
            Employee hemanshu = new Employee("Himanshu","angular",15000,2);
            Employee ishan = new Employee("Ishaan",".net",15000,3);
            repository.saveAll(List.of(yash,hemanshu,ishan));
        };

    }

}
