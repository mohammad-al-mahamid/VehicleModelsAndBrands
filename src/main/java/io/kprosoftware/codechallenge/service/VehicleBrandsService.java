package io.kprosoftware.codechallenge.service;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.entity.VehicleBrand;
import io.kprosoftware.codechallenge.exception.VehicleBrandNotFoundException;
import io.kprosoftware.codechallenge.repository.ModelRepository;
import io.kprosoftware.codechallenge.repository.VehicleBrandsRepository;

@Service
public class VehicleBrandsService {

  private Logger logger;
  @Autowired
  private VehicleBrandsRepository vehicleBrandsRepository;

  @Autowired
  private ModelRepository modelRepository;

  public VehicleBrandsService(Logger logger) {
    super();
    this.logger = logger;
  }

  @Transactional
  public ResponseEntity<List<VehicleBrand>> getVehicleBrands() {
    List<VehicleBrand> vehicleBrands = vehicleBrandsRepository.findAll();
    if (vehicleBrands.isEmpty()) {
      logger.info("List is Empty");
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    logger.info("Get a list of VehicleBrands ");
    return new ResponseEntity<>(vehicleBrands, HttpStatus.OK);
  }

  @Transactional
  public ResponseEntity<VehicleBrand> getVehicleBrandsById(Long id) {
    VehicleBrand result = vehicleBrandsRepository.findById(id)

        .orElseThrow(() -> new VehicleBrandNotFoundException(id));

    logger.info("VehicleBrands at " + id + " is " + result);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  public ResponseEntity<VehicleBrand> addVehicleBrand(VehicleBrand vehicleBrand) {
    VehicleBrand newVehicleBrand = new VehicleBrand(vehicleBrand.getName(), vehicleBrand.getPriceSegment());
    vehicleBrandsRepository.saveAndFlush(newVehicleBrand);

    logger.info("Saved VehicleBrands with id" + newVehicleBrand.getId());
    logger.info("VehicleBrands saved" + newVehicleBrand.toString());

    // Save the new Model object, assuming that there is at least one Model in the
    // list
    if (vehicleBrand.getModels() != null && !vehicleBrand.getModels().isEmpty()) {
      Model model = vehicleBrand.getModels().get(0);
      model.setVehicleBrand(newVehicleBrand); // Associate the Model with the new VehicleBrand
      model = modelRepository.saveAndFlush(model);
      logger.info("Saved Model with id: " + model.getId() + " for VehicleBrand with id: " + newVehicleBrand.getId());
    }
    return new ResponseEntity<>(newVehicleBrand, HttpStatus.CREATED);
  }

  @Transactional
  public ResponseEntity<VehicleBrand> UpdateVehicleBrand(VehicleBrand newVehicleBrand, Long id) {
    return vehicleBrandsRepository.findById(id)
        .map(vehicleBrands -> {
          logger.info("old VehicleBrands: " + vehicleBrandsRepository.findById(id).get());

          vehicleBrands.setName(newVehicleBrand.getName());
          vehicleBrands.setPriceSegment(newVehicleBrand.getPriceSegment());

          logger.info("replace was successful: " + vehicleBrands.toString());
          return new ResponseEntity<>(vehicleBrandsRepository.save(vehicleBrands), HttpStatus.OK);
        })
        .orElseThrow(() -> new VehicleBrandNotFoundException(id));
  }

  public ResponseEntity<HttpStatus> deleteVehicleBrandById(Long id) {

    if (!vehicleBrandsRepository.existsById(id)) {
      logger.warn("vehicleBrand with id" + id + " will be removed from the Database ");
      throw new VehicleBrandNotFoundException(id);
    }

    vehicleBrandsRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  public ResponseEntity<HttpStatus> deleteALLVehicleBrands() {
    List<VehicleBrand> result = vehicleBrandsRepository.findAll();

    if (result.isEmpty()) {
      throw new VehicleBrandNotFoundException();
    }

    logger.warn("Delete all VehicleBrands!!! ");
    vehicleBrandsRepository.deleteAll();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
