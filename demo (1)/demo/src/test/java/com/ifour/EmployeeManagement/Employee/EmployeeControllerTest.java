package com.ifour.EmployeeManagement.Employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void getEmployee() throws Exception {
        String uri = "/employee/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //Product[] productlist = super.mapFromJson(content, Product[].class);
        //assertEquals(content,"Get employee");
    }

    @Test
    void testGetEmployee() {
    }

    @Test
    @BeforeEach
    void addNewEmployee() throws Exception {
         String uri = "/employee/";
        Employee employee = new Employee();
        employee.setName("YASH");
        employee.setDept("java");
        employee.setDept_id(1);
        employee.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);

//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Payroll is created successfully");
    }

    @Test
    void deleteEmployee() throws Exception {
        String uri = "/employee/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Payroll is deleted successsfully");
    }

      @Test
      void updateEmployee() throws Exception {
        String uri = "/employee/1?name=Yash&dept=Temp";
        //Product product = new Product();
        Employee employee = new Employee();
        employee.setName("sarthak");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
          assertEquals(404,status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Payroll is updated successsfully");
    }
}