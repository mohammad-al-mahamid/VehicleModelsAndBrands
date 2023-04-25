package io.kprosoftware.codechallenge.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kprosoftware.codechallenge.entity.VehicleBrands;
import io.kprosoftware.codechallenge.exception.VehicleBrandNotFoundExceptionException;
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

  public VehicleBrands getVehicleBrandsById(Long id) {
    Optional<VehicleBrands> result = vehicleBrandsRepository.findById(id);

    if (!result.isPresent()) {
      logger.info("VehicleBrands Not Found");

    } else {
      logger.info("VehicleBrands at " + id + "is" + result.get());
      return result.get();
    }
    return null;
  }

  public VehicleBrands addVehicleBrands(VehicleBrands VehicleBrands) {
    VehicleBrands newVehicleBrands = vehicleBrandsRepository.saveAndFlush(VehicleBrands);
    logger.info("Saved VehicleBrands with id" + newVehicleBrands.getId());
    logger.info("VehicleBrands saved" + newVehicleBrands.toString());
    vehicleBrandsRepository.saveAndFlush(newVehicleBrands);
    return newVehicleBrands;
  }

  public VehicleBrands UpdateVehicleBrands(VehicleBrands newVehicleBrands, Long id) {
    return vehicleBrandsRepository.findById(id)
        .map(VehicleBrands -> {
          logger.info("old VehicleBrands: " + vehicleBrandsRepository.findById(id).get());
          VehicleBrands.setName(newVehicleBrands.getName());
          VehicleBrands.setPriceSegment(newVehicleBrands.getPriceSegment());

          logger.info("replace was successful: " + VehicleBrands.toString());
          return vehicleBrandsRepository.save(VehicleBrands);
        })
        .orElseThrow(() -> new VehicleBrandNotFoundExceptionException(id));
  }

  public void deleteVehicleBrandsById(Long id) {
    Optional<VehicleBrands> result = vehicleBrandsRepository.findById(id);

    if (result.isPresent()) {
      logger.warn("vehicleBrands with id" + id + " will be removed from the Database ");
      vehicleBrandsRepository.deleteById(id);
    } else {
      throw new VehicleBrandNotFoundExceptionException(id);
    }
  }

  public void deleteALLVehicleBrands() {
    List<VehicleBrands> result = vehicleBrandsRepository.findAll();

    if (result.isEmpty())
      throw new VehicleBrandNotFoundExceptionException();
    logger.warn("Delete ALL VehicleBrands!!! ");
    vehicleBrandsRepository.deleteAll();
  }
}
