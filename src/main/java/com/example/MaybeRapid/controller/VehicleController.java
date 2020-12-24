package com.example.MaybeRapid.controller;

import com.example.MaybeRapid.domain.Vehicle;
import com.example.MaybeRapid.repository.VehicleRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class VehicleController {

  private VehicleRepository vehicleRepository;

  public VehicleController(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @GetMapping("/vehicles")
  public List<Vehicle> getVehicle() {
    return vehicleRepository.findAll();
  }

  @GetMapping("/vehicle/{id}")
  public Vehicle getVehicle(@RequestParam(name = "id") String id) {
    return vehicleRepository.findOneById(id);
  }

  @PutMapping("/vehicle/{id}")
  public Vehicle putVehicle(@RequestParam(name = "id") String id) {
    return Vehicle;
  }

  @DeleteMapping("/vehicle/{id}")
  public Vehicle deleteVehicle(@RequestParam(name = "id") String id) {
    return Vehicle;
  }

  @PostMapping("/vehicle")
  public Vehicle postVehicle(@RequestBody Vehicle vehicle) {
    return Vehicle;
  }

}
