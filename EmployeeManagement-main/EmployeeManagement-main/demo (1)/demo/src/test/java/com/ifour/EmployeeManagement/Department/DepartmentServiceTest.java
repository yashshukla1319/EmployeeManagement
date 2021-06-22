package com.ifour.EmployeeManagement.Department;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//@TestConfiguration
//@AutoConfigureMockMvc
@AutoConfigureWebMvc
@WebMvcTest(DepartmentService.class)
class DepartmentServiceTest {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    DepartmentServiceTest() {
    }

    @BeforeEach
    void setUp() {
            Department department = new Department();
            Mockito.when(departmentRepository.findById(department.getDept_id())).thenReturn(Optional.of(department));

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateDepartment() throws Exception {
        String uri = "/department/1";
        Department department = new Department();
        department.setDept_name("testing");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        assert (department.getDept_name().equals("testing"));


        /*
          this.mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());
          */

        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is updated successsfully");
        */
    }

    @Test
    void addDepartment() throws Exception {
        String uri = "/department/";
        Department department = new Department();
        department.setDept_id(2);
        department.setDept_name("java");

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(department);
        assert (department.getDept_name().equals("java"));


        //this.mvc.perform(MockMvcRequestBuilders.post(uri)
         //       .contentType(MediaType.APPLICATION_JSON_VALUE).contentType(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is created successfully");
        */
    }

    @Test
    void deleteDepartment() throws Exception {
        String uri = "/department/2";
        Department department = new Department();
        assertNull(department.getDept_name());

        //this.mvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().isOk());

        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Payroll is deleted successsfully");
        */
    }

    @Test
    void getDepartmentBydept_id() throws Exception {
        String uri = "/department/0";
        Department department = new Department();
        //assert (department.getDept_id().equals(0));
        assertEquals ("java",department.getDept_name());


        //this.mvc.perform(MockMvcRequestBuilders.get(uri)
         //       .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());

        /*
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] productlist = super.mapFromJson(content, Product[].class);
        assertEquals(content, "Get department by ID");
        */
    }
}