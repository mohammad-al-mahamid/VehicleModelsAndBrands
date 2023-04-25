package io.kprosoftware.codechallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.kprosoftware.codechallenge.entity.VehicleBrand;
import io.kprosoftware.codechallenge.service.VehicleBrandsService;

@RestController
public class VehicleBrandController {
  @Autowired
  private VehicleBrandsService vehicleBrandsService;

  @GetMapping("/VehicleBrands")
  public ResponseEntity<List<VehicleBrand>> getVehicleBrands() {
    return vehicleBrandsService.getVehicleBrands();
  }

  @GetMapping("/VehicleBrands{id}")
  public ResponseEntity<VehicleBrand> getVehicleBrandById(@PathVariable Long id) {
    return vehicleBrandsService.getVehicleBrandsById(id);
  }

  @PostMapping("/VehicleBrand")
  public ResponseEntity<VehicleBrand> addVehicleBrand(@RequestBody VehicleBrand vehicleBrand) {
    return vehicleBrandsService.addVehicleBrand(vehicleBrand);
  }

  @PutMapping("/VehicleBrand/{id}")
  public ResponseEntity<VehicleBrand> UpdateVehicleBrand(@PathVariable Long id,
      @RequestBody VehicleBrand vehicleBrand) {
    return vehicleBrandsService.UpdateVehicleBrand(vehicleBrand, id);
  }

  @DeleteMapping("/VehicleBrand/{id}")
  public ResponseEntity<HttpStatus> deleteVehicleBrandById(@PathVariable Long id) {
    return vehicleBrandsService.deleteVehicleBrandById(id);
  }

  @DeleteMapping("/VehicleBrands")
  public ResponseEntity<HttpStatus> deleteVehicleBrands() {
    return vehicleBrandsService.deleteALLVehicleBrands();
  }

}
