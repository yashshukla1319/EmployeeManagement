package com.ifour.EmployeeManagement.Department;

import com.ifour.EmployeeManagement.Employee.Employee;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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
    @JoinColumn(name = "id",updatable = false,insertable = false)
    private Integer id;
    @NotFound(action = NotFoundAction.EXCEPTION)
    @ManyToOne
    @JoinColumn(name = "dept_id",updatable = false,insertable = false)
    private Employee employee;


    public Department() {
    }

    public Department(int dept_id, String dept_name) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
    }

    public Department(String dept_name) {
        this.dept_name = dept_name;
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
                '}';
    }

}

