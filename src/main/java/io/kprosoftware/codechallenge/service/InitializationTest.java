package io.kprosoftware.codechallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import javax.transaction.Transactional;

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.entity.VehicleBrand;
import io.kprosoftware.codechallenge.enum_.PriceSegment;

@Service
public class InitializationTest {
  @Autowired
  private VehicleBrandsService vehicleBrandsService;
  @Autowired
  private ModelService modelService;

  private Logger logger;

  public InitializationTest(Logger logger) {
    super();
    this.logger = logger;
  }

  @Transactional
  public void initDB() {
    if (vehicleBrandsService.countVehicleBrands().getBody().equals(0L)) {
      logger.info("Database is empty. DB  initialization.");
      VehicleBrand vehicleBrand = new VehicleBrand();
      vehicleBrand.setName("BMW");
      vehicleBrand.setPriceSegment(PriceSegment.Low);

      vehicleBrandsService.addVehicleBrand(vehicleBrand);

      Model bmwIx = new Model("BMW IX", 326);
      Model bmwXm = new Model("BMW XM", 653);

      bmwIx.setVehicleBrand(vehicleBrand);
      bmwXm.setVehicleBrand(vehicleBrand);

      modelService.addModel(1L, bmwIx);
      modelService.addModel(1L, bmwXm);
    } else {
      logger.info("Database is not empty. Skipping initialization.");
    }
  }
}
