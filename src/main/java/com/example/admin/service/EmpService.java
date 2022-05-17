package com.example.admin.service;

import com.example.admin.mapper.EmpMapper;
import com.example.admin.bean.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    EmpMapper empMapper;

    public Emp getEmp(Integer id){
        return empMapper.getEmpById(id);
    }

    public void saveEmp(Emp emp) {
        empMapper.insertEmp(emp);
    }
}
