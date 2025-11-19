package com.arnex.booting.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arnex.booting.data.entity.EmployeeEntity;
import com.arnex.booting.data.repository.EmployeeRepository;
import com.arnex.booting.web.model.Employee;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getEmployeesPage(Model model) {
        List<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        employeeEntities.forEach(e -> employees.add(new Employee(e.getEmployeeId(), e.getFirstName(), e.getLastName(), e.getPosition().toString())));
        model.addAttribute("employees", employees);
        return "employees";
    }
    
}
