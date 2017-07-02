package com.zucc.demo.dao;
import java.util.List;

import com.zucc.demo.model.EmployeeVO;

public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
}