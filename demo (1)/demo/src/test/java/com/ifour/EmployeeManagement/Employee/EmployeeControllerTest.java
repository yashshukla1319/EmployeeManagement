package com.ifour.EmployeeManagement.Employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void getEmployee() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employee/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addNewEmployee() throws Exception {
        String uri = "/employee/";
        Employee employee = new Employee();
        employee.setName("YASH");
        employee.setDept("java");
        employee.setDept_id(1);
        employee.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);

        this.mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteEmployee() throws Exception {
        String uri = "/employee/1";
        this.mockMvc.perform(MockMvcRequestBuilders.delete(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(404, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        assertEquals(content, "Payroll is deleted successsfully");
    }

      @Test
      void updateEmployee() throws Exception {
        String uri = "/employee/1?name=Yash&dept=Temp";
        Employee employee = new Employee();
        employee.setName("sarthak");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
       this.mockMvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

//        int status = mvcResult.getResponse().getStatus();
//          assertEquals(404,status);
////        String content = mvcResult.getResponse().getContentAsString();
////        assertEquals(content, "Payroll is updated successsfully");
    }
}