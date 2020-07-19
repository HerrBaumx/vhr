package org.jxiao.vhrself.service;

import org.jxiao.vhrself.mapper.SalaryMapper;
import org.jxiao.vhrself.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }
}
