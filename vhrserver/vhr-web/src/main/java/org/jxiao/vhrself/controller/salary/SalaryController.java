package org.jxiao.vhrself.controller.salary;

import org.jxiao.vhrself.model.RespBean;
import org.jxiao.vhrself.model.Salary;
import org.jxiao.vhrself.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary)==1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败!");
    }
}
