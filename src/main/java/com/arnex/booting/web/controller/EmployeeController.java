package com.arnex.booting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arnex.booting.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployeesPage(Model model) {
        model.addAttribute("employees", this.employeeService.getAllEmployees());
        return "employees";
    }
    
}
