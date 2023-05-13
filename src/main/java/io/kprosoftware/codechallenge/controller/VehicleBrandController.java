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
    List<VehicleBrand> vehicleBrands = vehicleBrandsService.getVehicleBrands();

    if (vehicleBrands.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(vehicleBrands, HttpStatus.OK);

  }

  @GetMapping("/VehicleBrands{id}")
  public ResponseEntity<VehicleBrand> getVehicleBrandById(@PathVariable Long id) {
    VehicleBrand vehicleBrand = vehicleBrandsService.getVehicleBrandsById(id);
    return new ResponseEntity<>(vehicleBrand, HttpStatus.OK);

  }

  @PostMapping("/VehicleBrand")
  public ResponseEntity<VehicleBrand> addVehicleBrand(@RequestBody VehicleBrand vehicleBrand) {
    VehicleBrand newVehicleBrand = vehicleBrandsService.addVehicleBrand(vehicleBrand);
    return new ResponseEntity<>(newVehicleBrand, HttpStatus.CREATED);

  }

  @PutMapping("/VehicleBrand/{id}")
  public ResponseEntity<VehicleBrand> UpdateVehicleBrand(@PathVariable Long id,
      @RequestBody VehicleBrand vehicleBrand) {
    VehicleBrand updatedVehicleBrand = vehicleBrandsService.UpdateVehicleBrand(vehicleBrand, id);
    return new ResponseEntity<>(updatedVehicleBrand, HttpStatus.OK);

  }

  @DeleteMapping("/VehicleBrand/{id}")
  public ResponseEntity<HttpStatus> deleteVehicleBrandById(@PathVariable Long id) {
    vehicleBrandsService.deleteVehicleBrandById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

  @DeleteMapping("/VehicleBrands")
  public ResponseEntity<HttpStatus> deleteVehicleBrands() {
    vehicleBrandsService.deleteALLVehicleBrands();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

}
