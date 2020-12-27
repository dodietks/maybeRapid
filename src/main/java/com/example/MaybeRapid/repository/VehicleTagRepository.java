package com.example.MaybeRapid.repository;

import com.example.MaybeRapid.domain.VehicleTag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTagRepository extends CrudRepository<VehicleTag, Long> {

}
