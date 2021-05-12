package com.ifour.EmployeeManagement.Payroll;


import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    public PayrollService payrollService;

    public List<Payroll> getPayroll() {
        return payrollService.getPayroll();

    }

    public Optional<Payroll> getPayrollByE_id(int e_id) {
        return payrollService.getPayrollByE_id(e_id);
    }

    public void addPayroll(Payroll payroll) {
        Optional<Payroll>getPayrollByE_id = payrollService.f
        if(getPayrollByE_id.isPresent())
        {
            return new IllegalStateException("Employee with Id:"+E_id+"is already present");
        }
    }

    public void deletePayroll(int e_id) {
    }

    public void updatePayroll(int e_id, int basic, int allowance, int deduction, int net_salary) {
    }
}
