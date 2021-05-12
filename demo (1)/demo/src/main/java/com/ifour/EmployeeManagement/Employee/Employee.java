package com.ifour.EmployeeManagement.Employee;

import javax.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(name="employee_sequence",
    sequenceName="employee_sequence",
    allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private int id;
    private String name;
    private String dept;
    private int salary;
    private int dept_id;

    public Employee() {
    }

    public Employee(int id, String name, String dept, int salary,int dept_id) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public Employee(String name, String dept, int salary, int dept_id) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }
}
