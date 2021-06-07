package com.ifour.EmployeeManagement.Department;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifour.EmployeeManagement.Employee.EmployeeController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Autowired
    private MockMvc mvc;

    @Test
    void getDepartmentBydept_id() throws Exception {
        String uri = "/department/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
        //Product[] productlist = super.mapFromJson(content, Product[].class);
        //assertEquals(true, getDepartmentBydept_id());
    }

    @Test
    void addDepartment() throws Exception {
        String uri = "/department/";
        Department department = new Department();
        department.setDept_id(002);
        department.setDept_name("mvc");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is created successfully");
    }

    @Test
    void deleteDepartment() throws Exception {
        String uri = "/department/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is deleted successsfully");
    }

    @Test
    void updateDepartment() throws Exception {
        String uri = "/department/";
        Department department = new Department();
        department.setDept_name("node");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is updated successsfully");
    }
}