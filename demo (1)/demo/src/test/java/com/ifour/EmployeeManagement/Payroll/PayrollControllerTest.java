package com.ifour.EmployeeManagement.Payroll;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PayrollController.class)
class PayrollControllerTest {

    @MockBean
    private PayrollService payrollService;

    @Autowired
    private MockMvc mvc;

    @Test
    void getPayroll() throws Exception {
        String uri = "/payroll/";
        this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //Product[] productlist = super.mapFromJson(content, Product[].class);
        //assertEquals(content,"Get payroll");

    }

    @Test
    void getPayrollByE_id() throws Exception {
        String uri = "/payroll/1";
        this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //Product[] productlist = super.mapFromJson(content, Product[].class);
        //assertEquals(content,"Get payroll by ID");
    }

    @Test
    void addPayroll() throws Exception {
        String uri = "/payroll/1";
        Payroll payroll = new Payroll();
        payroll.setE_id(1);
        payroll.setDeduction(8000);
        payroll.setAllowance(7000);
        payroll.setBasic(6500);
        payroll.setNet_salary(7500);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is created successfully");
    }

    @Test
    void deletePayroll() throws Exception {
        String uri = "/payroll/2";
        this.mvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is deleted successsfully");
    }

    @Test
    void updatePayroll() throws Exception {
        String uri = "/payroll/1";
        Payroll payroll = new Payroll();
        payroll.setBasic(5000);
        payroll.setAllowance(4000);
        payroll.setDeduction(3000);
        payroll.setE_id(3);

        ObjectMapper objectMapper = new ObjectMapper();
        String inputJson = objectMapper.writeValueAsString(payroll);
        this.mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andExpect(MockMvcResultMatchers.status().isOk());

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(404, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Payroll is updated successsfully");
    }
}