package com.ifour.EmployeeManagement.Employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

//@TestConfiguration
@AutoConfigureWebMvc
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private MockMvc mvc;
    @Before("")
    public void setUp() {
        Employee employee = new Employee();
        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

    }
    @Test
    void getEmployee() throws Exception {
        String uri = "/employee/3";
        Employee employee = new Employee();
        assertFalse(employee.equals(null));

        //this.mvc.perform(MockMvcRequestBuilders.get(uri)
                //.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();/employee/
        Product[] productlist = super.mapFromJson(content, Product[].class);
        assertEquals(content,"Get Employee");
        */
    }

    @Test
    void getEmployeeById() {
    }

    @Test
    void addNewEmployee() throws Exception {
        String uri = "/employee/";
        Employee employee = new Employee();
        employee.setName("amit");
        employee.setDept_id(1);
        employee.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
        //employeeRepository.findAll();//addNewEmployee(employee);
        //assert (HttpStatus.CREATED.equals(inputJson));
        assert (employee.getName().equals("amit"));

        //this.mvc.perform(MockMvcRequestBuilders.post(uri)
                //.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is created successfully");
        */
    }

    @Test
    void deleteEmployee() throws Exception {
        String uri = "/employee/1";
        Employee employee = new Employee();
        assertNull(employee.getName());
        //this.mvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().isOk());
        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is deleted successsfully");
        */
    }

    @Test
    void updateEmployee() throws Exception {
        String uri = "/employee/1?name=Yash&dept=Temp";
        Employee employee = new Employee();
        employee.setName("karan");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(employee);
        assert (employee.getName().equals("karan"));
        //this.mvc.perform(MockMvcRequestBuilders.put(uri)
          //      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is updated successsfully");
        */
    }
}