package com.ifour.EmployeeManagement.Department;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @MockBean
    private DepartmentService departmentService;
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
        this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //Product[] productlist = super.mapFromJson(content, Product[].class);
        //assertEquals(true, getDepartmentBydept_id());
    }

    @Test
    void addDepartment() throws Exception {
        String uri = "/department/";
        Department department = new Department();
        department.setDept_id(2);
        department.setDept_name("mvc");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is created successfully");
    }

    @Test
    void deleteDepartment() throws Exception {
        String uri = "/department/2";
        this.mvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().isOk());
        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is deleted successsfully");
    }

    @Test
    void updateDepartment() throws Exception {
        String uri = "/department/2";
        Department department = new Department();
        department.setDept_name("node");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        this.mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is updated successsfully");
    }
}