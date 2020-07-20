package org.jxiao.vhrself.controller.salary;

import org.jxiao.vhrself.model.RespBean;
import org.jxiao.vhrself.model.RespPageBean;
import org.jxiao.vhrself.model.Salary;
import org.jxiao.vhrself.service.EmployeeService;
import org.jxiao.vhrself.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size) {

        return employeeService.getEmployeeByPageWithSalary(page, size);

    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }
}
