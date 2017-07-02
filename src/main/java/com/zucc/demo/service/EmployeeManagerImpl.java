package com.zucc.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zucc.demo.dao.EmployeeDAO;
import com.zucc.demo.model.EmployeeVO;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

    @Autowired
    EmployeeDAO dao;

    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }
}