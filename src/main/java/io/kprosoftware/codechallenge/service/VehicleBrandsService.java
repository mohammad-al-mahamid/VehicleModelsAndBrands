package io.kprosoftware.codechallenge.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kprosoftware.codechallenge.entity.VehicleBrands;
import io.kprosoftware.codechallenge.repository.VehicleBrandsRepository;

@Service
public class VehicleBrandsService {

  private Logger logger;
  @Autowired
  private VehicleBrandsRepository vehicleBrandsRepository;

  public VehicleBrandsService(Logger logger) {
    super();
    this.logger = logger;
  }

  public List<VehicleBrands> getVehicleBrands() {
    List<VehicleBrands> vehicleBrands = vehicleBrandsRepository.findAll();
    if (vehicleBrands.isEmpty()) {
      logger.info("List is Empty");
    }
    return vehicleBrands;
  }
}
