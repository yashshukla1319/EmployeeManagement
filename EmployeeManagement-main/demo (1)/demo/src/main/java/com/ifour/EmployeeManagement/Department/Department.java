package com.ifour.EmployeeManagement.Department;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@EnableJpaRepositories
@IdClass(Department.class)
//@SecondaryTable(name = "EmployeeInDepartment", pkJoinColumns= @PrimaryKeyJoinColumns(foreignKey = "dept_id"))
public class Department implements Serializable {

    // removed @Id annotation

    @SequenceGenerator(name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )

    @Column
    @Id
    private int dept_id;
    private String dept_name;
    @Id
    private int employee_id;
    private String employee_name;
    private String employee_post;


    public Department() {
    }

    public Department(int dept_id, String dept_name,int employee_id,String employee_name,String employee_post) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_post = employee_post;
    }

    public Department(String dept_name,String employee_name, String employee_post) {
        this.dept_name = dept_name;
        this.employee_name = employee_name;
        this.employee_post = employee_post;
    }

    public Department(int id, String name, String dept, int salary, int dept_id,String employee_name,String employee_post,int employee_id) {
    }

    public Department(int id, String name, String dept, int salary, int dept_id) {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_post() {
        return employee_post;
    }

    public void setEmployee_post(String employee_post) {
        this.employee_post = employee_post;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", employee_id=" + employee_id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_post='" + employee_post + '\'' +
                '}';
    }

}

