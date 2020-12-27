package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Employee;
import com.example.MaybeRapid.repository.EmployeeRepository;
import com.example.MaybeRapid.util.exception.InvalidTransationReferenceException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @PostMapping("/employees")
  public Long createEmployee(@RequestBody Employee employee) {
    return employee.getId();
  }

  @GetMapping("/employees")
  public Iterable<Employee> viewAllEmployee() {
    return employeeRepository.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee viewEmployeeById(@PathVariable("id") Long id) {
    Optional<Employee> transaction = employeeRepository.findById(id);
    if(transaction.isPresent()) {
      return transaction.get();
    }

    throw new InvalidTransationReferenceException("Invalid transaction reference provided");
  }
}
