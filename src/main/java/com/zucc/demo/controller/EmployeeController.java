package com.zucc.demo.controller;

import com.zucc.demo.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zucc.demo.service.EmployeeManager;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee-module")
public class EmployeeController {
    @Autowired
    EmployeeManager manager;

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public ModelAndView getAllEmployees(Model model) {
        model.addAttribute("employees", manager.getAllEmployees());
        model.addAttribute("searchWord", new String());
        return new ModelAndView("employeesListDisplay", "command", new SearchParam());
    }


    @RequestMapping(value = "/searchEmployees", method = RequestMethod.POST)
    public ModelAndView searchEmployees(SearchParam searchParam, BindingResult br, Model model) {
        List<EmployeeVO> all = manager.getAllEmployees();
        if(!StringUtils.isEmpty(searchParam.getWord())) {
            List<EmployeeVO> result = new ArrayList<>();
            for(EmployeeVO employeeVO : all) {
                if(employeeVO.getFirstName().contains(searchParam.getWord())) {
                    result.add(employeeVO);
                }
            }
            model.addAttribute("employees", result);
        } else {
            model.addAttribute("employees", all);
        }
        return new ModelAndView("employeesListDisplay", "command", new SearchParam());
    }
}