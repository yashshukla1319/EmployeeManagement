package com.ifour.EmployeeManagement.Department;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

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
    byte getDepartmentBydept_id() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        //Product[] productlist = super.mapFromJson(content, Product[].class);
        assertEquals(true, getDepartmentBydept_id());
        return 0;
    }

    @Test
    void addDepartment() throws Exception {
        String uri = "/products";
        Department department = new Department();
        department.setDept_id(1);
        department.setDept_name("java");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is created successfully");
    }

    @Test
    void deleteDepartment() throws Exception {
        String uri = "/products/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is deleted successsfully");
    }

    @Test
    void updateDepartment() throws Exception {
        String uri = "/products/2";
        Department department = new Department();
        department.setDept_name("");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is updated successsfully");
    }
}