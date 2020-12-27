package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.VehicleTag;
import com.example.MaybeRapid.repository.VehicleTagRepository;
import com.example.MaybeRapid.utils.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class VehicleTagController {

  private VehicleTagRepository vehicleTagRepository;

  public VehicleTagController(VehicleTagRepository vehicleTagRepository) {
    this.vehicleTagRepository = vehicleTagRepository;
  }

  @GetMapping("/vehicle/tags")
  public Iterable<VehicleTag> getVehicles() { return vehicleTagRepository.findAll(); }

  @GetMapping("/vehicle/tag/{id}")
  public VehicleTag getVehicle(@PathVariable("id") Long id) {
    return  Assert.found(vehicleTagRepository.findById(id), "not found");
  }

  @PutMapping("/vehicle/tag/{id}")
  public VehicleTag putVehicle(@PathVariable("id") Long id, @RequestBody VehicleTag vehicleTag) {
    VehicleTag vehicleTag1 = Assert.found(vehicleTagRepository.findById(id), "not found");
    vehicleTag1.setTag(vehicleTag.getTag());
    return vehicleTag1;
  }

  @PostMapping("/vehicle/tag")
  public VehicleTag postVehicle(@RequestBody VehicleTag vehicleTag) {
    return vehicleTagRepository.save(vehicleTag);
  }
}
