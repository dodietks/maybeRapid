package com.example.MaybeRapid.repository;

import com.example.MaybeRapid.domain.Resident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends CrudRepository<Resident, Long> {


}
