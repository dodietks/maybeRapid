package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Vehicle;
import com.example.MaybeRapid.repository.VehicleRepository;
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
public class VehicleController {

  private VehicleRepository vehicleRepository;

  public VehicleController(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @GetMapping("/vehicles")
  public Iterable<Vehicle> getVehicles() { return vehicleRepository.findAll(); }

  @GetMapping("/vehicle/{id}")
  public Vehicle getVehicle(@PathVariable("id") Long id) {
    return  Assert.found(vehicleRepository.findById(id), "not found");
  }

  @PutMapping("/vehicle/{id}")
  public Vehicle putVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
    Vehicle vehicle1 = Assert.found(vehicleRepository.findById(id), "not found");
    vehicle1.setModel(vehicle.getModel());
    return vehicle1;
  }

  @PostMapping("/vehicle")
  public Vehicle postVehicle(@RequestBody Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }
}
