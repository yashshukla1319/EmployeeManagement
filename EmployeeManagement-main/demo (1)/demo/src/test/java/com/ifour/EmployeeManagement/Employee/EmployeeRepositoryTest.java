package com.ifour.EmployeeManagement.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    @Test
    @BeforeEach
    void setUp() {
        System.out.println("This is setup method");
    }
    @Test
    @AfterEach
    void tearDown() {
        System.out.println("This is teardown method");
    }
}