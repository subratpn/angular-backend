package com.example.angular.backend.service;

import com.example.angular.backend.dto.EmployeeDTO;
import com.example.angular.backend.model.Employee;
import com.example.angular.backend.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getEmployees() {
        final List<Employee> employees = employeeRepo.findAll();
        return employees;
    }

    public Optional<Employee> getEmployee(String employeeId) {
        return employeeRepo.findById(employeeId);
    }

    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO) {
        final Optional<Employee> optionalEmployee = employeeRepo.findById(employeeDTO.getId());
        if (optionalEmployee.isPresent()) {
            final Employee employee = optionalEmployee.get();
            employee.setName(employeeDTO.getName());
            return employeeRepo.save(employee);
        }
        return null;
    }

    public void deleteEmployee(String employeeId) {
        employeeRepo.deleteById(employeeId);
    }
}
