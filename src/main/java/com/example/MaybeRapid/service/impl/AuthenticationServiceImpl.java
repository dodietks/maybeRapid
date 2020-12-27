package com.example.MaybeRapid.service.impl;

import com.example.MaybeRapid.domain.User;
import com.example.MaybeRapid.repository.UserRepository;
import com.example.MaybeRapid.service.AuthenticationService;
import com.example.MaybeRapid.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User authentication(User user) {
    return Assert.found(userRepository.findOneByEmailAndPassword(user.getEmail(), user.getPassword()), "user not found");
  }
}
