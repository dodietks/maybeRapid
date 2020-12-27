package com.example.MaybeRapid.service;

import com.example.MaybeRapid.domain.User;

public interface AuthenticationService {

  User authentication(User user);
}
