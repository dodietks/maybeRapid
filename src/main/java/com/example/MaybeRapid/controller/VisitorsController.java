package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Visitor;
import com.example.MaybeRapid.repository.VisitorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class VisitorsController {

  private VisitorRepository visitorRepository;

  public VisitorsController(VisitorRepository visitorRepository) {
    this.visitorRepository = visitorRepository;
  }

  @GetMapping("/visitors")
  public List<Visitor> getVisitors() {
    return visitorRepository.findAll();
  }

  @GetMapping("/visitor/{id}")
  public Visitor getVisitors(@RequestParam(name = "id") String id) {
    return visitorRepository.findOneById(id);
  }

  @PutMapping("/visitor/{id}")
  public String putVisitor(@RequestParam(name = "id") String id) {
    return "visitorRepository";
  }

  @DeleteMapping("/visitor/{id}")
  public String deleteVisitor(@RequestParam(name = "id") String id) {
    return "test" + id;
  }

  @PostMapping("/visitor")
  public String postVisitor(@RequestBody Visitor visitants) {
    return "creating";
  }

}
