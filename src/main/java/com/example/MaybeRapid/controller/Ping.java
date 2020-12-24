package com.example.MaybeRapid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Ping {

  @GetMapping("/ping")
  public String ping(){
    return "pong";
  }
}
