package com.ifour.EmployeeManagement.Department;

import javax.persistence.*;

@Entity
@Table
//@SecondaryTable(name = "EmployeeInDepartment", pkJoinColumns = @PrimaryKeyJoinColumn( name = "dept_id"))
public class EmployeeInDepartment {
    private int id;
    private String name;
    private String dept;
    private int salary;
    @Id
    private int dept_id;

    public EmployeeInDepartment() {
    }

    public EmployeeInDepartment(int id, String name, String dept, int salary, int dept_id) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.dept_id = dept_id;
    }

    public EmployeeInDepartment(String name, String dept, int salary, int dept_id) {
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

    public void setDept_id(){
        this.dept_id = dept_id;
    }
}
