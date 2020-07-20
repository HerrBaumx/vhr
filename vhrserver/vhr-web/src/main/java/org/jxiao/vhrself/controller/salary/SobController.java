package org.jxiao.vhrself.controller.salary;

import org.jxiao.vhrself.model.RespBean;
import org.jxiao.vhrself.model.RespPageBean;
import org.jxiao.vhrself.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size) {

        return employeeService.getEmployeeByPageWithSalary(page, size);

    }
}
