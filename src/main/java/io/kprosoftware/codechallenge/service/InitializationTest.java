package io.kprosoftware.codechallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.entity.VehicleBrand;
import io.kprosoftware.codechallenge.enum_.PriceSegment;
import io.kprosoftware.codechallenge.repository.VehicleBrandsRepository;

@Service
public class InitializationTest {
  @Autowired
  private VehicleBrandsRepository vehicleBrandsRepository;
  @Autowired
  private ModelService modelService;

  @Transactional
  public void initDB() {
    VehicleBrand vehicleBrand = new VehicleBrand("BMW", PriceSegment.Low);
    vehicleBrandsRepository.save(vehicleBrand);

    Model bmwIx = new Model("BMW IX", 326, vehicleBrand);
    Model bmwXm = new Model("BMW XM", 653, vehicleBrand);

    modelService.addModel(vehicleBrand.getId(), bmwIx);
    modelService.addModel(vehicleBrand.getId(), bmwXm);
  }
}
