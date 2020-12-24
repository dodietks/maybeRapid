package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Visitant;
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

  @GetMapping("/visitors")
  public String getVisitors(@RequestParam(name = "id", required = false) String id) {
    return "test";
  }

  @PutMapping("/visitor")
  public String putVisitor(@RequestParam(name = "id") String id) {
    return "test";
  }

  @DeleteMapping("/visitor/{id}")
  public String deleteVisitor(@RequestParam(name = "id") String id) {
    return "test" + id;
  }

  @PostMapping("/visitor")
  public String postVisitor(@RequestBody Visitant visitants) {
    return "creating";
  }

}
