package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.User;
import com.example.MaybeRapid.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("/auth")
  public User createEmployee(@RequestBody User user) {
    return authenticationService.authentication(user);
  }
}
