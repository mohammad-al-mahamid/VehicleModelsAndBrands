package io.kprosoftware.codechallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kprosoftware.codechallenge.entity.VehicleBrands;
import io.kprosoftware.codechallenge.enum_.PriceSegment;
import io.kprosoftware.codechallenge.repository.VehicleBrandsRepository;

@Service
public class InitializationTest {
  @Autowired
  private VehicleBrandsRepository vehicleBrandsRepository;

  public void initDB() {
    VehicleBrands vehicleBrands = new VehicleBrands("BMW", PriceSegment.Low);
    vehicleBrandsRepository.save(vehicleBrands);
  }
}
