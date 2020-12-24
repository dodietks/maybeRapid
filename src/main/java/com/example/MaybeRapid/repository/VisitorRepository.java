package com.example.MaybeRapid.repository;

import com.example.MaybeRapid.domain.Visitor;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository {

  List<Visitor> findAll();

  Visitor findOneById(String id);
}
