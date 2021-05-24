package com.ifour.EmployeeManagement.Payroll;


import com.ifour.EmployeeManagement.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    public PayrollRepository payrollRepository;

    public List<Payroll> getPayroll() {
        return payrollRepository.findAll();

    }

    public Optional<Payroll> getPayrollByE_id(int e_id) {
        return payrollRepository.findById(e_id);
    }

    public void addPayroll(Payroll payroll) {

        payrollRepository.save(payroll);
    }

    public void deletePayroll(int e_id) {
        boolean exist = payrollRepository.existsById(e_id);
        if(!exist)
        {
            throw new IllegalStateException("Employee with Id does not exists");
        }
        payrollRepository.deleteById(e_id);
    }
    @Transactional
    public void updatePayroll(int e_id, int basic, int allowance, int deduction, int net_salary) {
        Payroll payroll = payrollRepository.findById(e_id).orElseThrow(()->new IllegalStateException("Employee with Id"+e_id+"is not present"));

        if(!Objects.equals(payroll.getBasic(),basic))
        {
            payroll.setBasic(basic);
        }

        if(!Objects.equals(payroll.getAllowance(),allowance))
        {
            payroll.setAllowance(allowance);
        }

        if(!Objects.equals(payroll.getDeduction(),deduction))
        {
            payroll.setDeduction(deduction);
        }

        payrollRepository.save(payroll);
    }

}
