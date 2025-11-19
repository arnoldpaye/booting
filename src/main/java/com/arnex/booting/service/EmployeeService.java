package com.arnex.booting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.arnex.booting.data.entity.EmployeeEntity;
import com.arnex.booting.data.entity.Position;
import com.arnex.booting.data.repository.EmployeeRepository;
import com.arnex.booting.web.model.Employee;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> entities = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(entities.size());
        entities.forEach(e -> employees.add(getEmployeeFromEntity(e)));
        return employees;
    }

    public Employee getEmployeeById(UUID id) {
        Optional<EmployeeEntity> entity = this.employeeRepository.findById(id);
        if (entity.isEmpty()) {
            return null;
        } else {
            return this.getEmployeeFromEntity(entity.get());
        }
    }

    public Employee addEmployee(Employee employee) {
        EmployeeEntity entity = this.getEmployeeEntityFromEmployee(employee);
        entity = this.employeeRepository.save(entity);
        return this.getEmployeeFromEntity(entity);
    }

    public Employee updateEmployee(Employee employee) {
        EmployeeEntity entity = this.getEmployeeEntityFromEmployee(employee);
        entity = this.employeeRepository.save(entity);
        return this.getEmployeeFromEntity(entity);
    }

    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    private Employee getEmployeeFromEntity(EmployeeEntity entity) {
        return new Employee(entity.getEmployeeId(), entity.getFirstName(), entity.getLastName(), entity.getPosition().toString());
    }

    private EmployeeEntity getEmployeeEntityFromEmployee(Employee employee) {
        return new EmployeeEntity(employee.getId(), employee.getFirstName(), employee.getLastName(), Position.valueOf(employee.getPosition()));
    }
}
