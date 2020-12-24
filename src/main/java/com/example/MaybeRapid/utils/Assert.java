package com.example.MaybeRapid.utils;

import java.util.Optional;

public class Assert extends org.springframework.util.Assert {

  public static <T> T found(Optional<T> t, String message){
    if (!t.isPresent()) {
      throw new NotFoundException(message);
    }

    return t.get();
  }

  public static void isFalse(boolean condition, String message) {
    isTrue(!condition, message);
  }
}
