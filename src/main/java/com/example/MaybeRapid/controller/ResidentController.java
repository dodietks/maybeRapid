package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Resident;
import com.example.MaybeRapid.repository.ResidentRepository;
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
public class ResidentController {

  @Autowired
  private ResidentRepository residentRepository;

  @PostMapping("/create")
  public Long createTransaction(@RequestBody Resident resident) {
    return resident.getId();
  }

  @GetMapping("/viewAll")
  public Iterable<Resident> viewAllTransactions() {
    return residentRepository.findAll();
  }

  @GetMapping("/view/{id}")
  public Resident viewTransactionById(@PathVariable("id") Long id) {
    Optional<Resident> transaction = residentRepository.findById(id);
    if (transaction.isPresent()) {
      return transaction.get();
    }

    throw new InvalidTransationReferenceException("Invalid transaction reference provided");
  }
}
