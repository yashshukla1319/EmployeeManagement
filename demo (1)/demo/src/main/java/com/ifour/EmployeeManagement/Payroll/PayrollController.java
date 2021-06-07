package com.ifour.EmployeeManagement.Payroll;

import com.ifour.EmployeeManagement.Department.Department;
import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    public PayrollService payrollService;

    @RequestMapping(path = "/")
    public List<Payroll> getPayroll()
    {
        System.out.println("Get All payroll Called");
        return payrollService.getPayroll();
    }

    @RequestMapping(path = "/{E_id}")
    public Optional<Payroll> getPayrollByE_id(@PathVariable("id")int E_id)
    {
        System.out.println("Get Payroll by ID Called");
        System.out.println(E_id);
        return payrollService.getPayrollByE_id(E_id);
    }
    @RequestMapping(path="/{E_id}", method = RequestMethod.POST)
    public void addPayroll(@RequestBody Payroll payroll)
    {
        payrollService.addPayroll(payroll);
    }

    @RequestMapping(path = "/{E_id}", method = RequestMethod.DELETE)
    public void deletePayroll(@PathVariable("E_id")int E_id)
    {
        payrollService.deletePayroll(E_id);
    }


    @RequestMapping(path = "/{E_id}", method = RequestMethod.PUT)
    public void updatePayroll(@PathVariable("E_id")
                                 @RequestParam(required = false) int E_id,
                                 @RequestParam(required = false) int basic,
                                 @RequestParam(required = false)int allowance,
                                 @RequestParam(required = false)int deduction,
                                 @RequestParam(required = false)int net_salary)
    {
        payrollService.updatePayroll(E_id,basic,allowance,deduction,net_salary);
    }

}
