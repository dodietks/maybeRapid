package com.example.MaybeRapid.repository;

import com.example.MaybeRapid.domain.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findOneByEmailAndPassword(String email, String password);
}
