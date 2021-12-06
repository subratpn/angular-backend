package com.example.angular.backend.controller;


import com.example.angular.backend.dto.EmployeeDTO;
import com.example.angular.backend.model.Employee;
import com.example.angular.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {

        return employeeService.getEmployees();

    }

    @GetMapping("{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee : " + employeeId + " deleted successfully";
    }

}
