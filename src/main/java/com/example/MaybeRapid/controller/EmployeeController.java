package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Employee;
import com.example.MaybeRapid.repository.EmployeeRepository;
import com.example.MaybeRapid.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  @GetMapping("/employees")
  public Iterable<Employee> viewAllEmployee() {
    return employeeRepository.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee viewEmployeeById(@PathVariable("id") Long id) {
    return Assert.found(employeeRepository.findById(id), "entity not found");
  }

  @PutMapping("/employees/{id}")
  public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee) {
    Employee employee1 = Assert.found(employeeRepository.findById(id), "entity not found");
    employee1.setActive(employee.getActive());
    employee1.setFunction(employee.getFunction());
    employee1.setName(employee.getName());
    employee1.setTag(employee.getTag());
    return employee;
  }
}
