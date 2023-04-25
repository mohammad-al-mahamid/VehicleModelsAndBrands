package io.kprosoftware.codechallenge.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.entity.VehicleBrand;
import io.kprosoftware.codechallenge.exception.ModelNotFoundException;
import io.kprosoftware.codechallenge.exception.VehicleBrandNotFoundException;
import io.kprosoftware.codechallenge.repository.ModelRepository;
import io.kprosoftware.codechallenge.repository.VehicleBrandsRepository;

@Service
public class ModelService {
  private Logger logger;
  @Autowired
  private ModelRepository modelRepository;
  @Autowired
  private VehicleBrandsRepository vehicleBrandsRepository;

  public ModelService(Logger logger) {
    super();
    this.logger = logger;
  }

  public ResponseEntity<List<Model>> getModels() {
    List<Model> models = modelRepository.findAll();
    if (models.isEmpty()) {
      logger.info("Model List is Empty");
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    logger.info("Get a list of models");
    return new ResponseEntity<>(models, HttpStatus.OK);
  }

  public ResponseEntity<Model> getModelById(Long id) {
    Model result = modelRepository.findById(id)
        .orElseThrow(() -> new ModelNotFoundException(id));

    logger.info("model with " + id + " is " + result);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  public ResponseEntity<Model> addModel(Long vehicleBrandId, Model model) {
    VehicleBrand existingVehicleBrand = checkifVehicleBrandExist(vehicleBrandId);
    Model newModel = new Model(model.getName(), model.getEnginePower(), existingVehicleBrand);

    logger.info("Saved Models with id" + newModel.getId());
    logger.info("Models saved" + newModel.toString());

    modelRepository.saveAndFlush(newModel);

    return new ResponseEntity<>(newModel, HttpStatus.CREATED);
  }

  public ResponseEntity<Model> UpdateModel(Model newModel, Long id) {
    return modelRepository.findById(id)
        .map(model -> {
          logger.info("old Models: " + modelRepository.findById(id).get());
          model.setName(newModel.getName());
          model.setEnginePower(newModel.getEnginePower());

          logger.info("Update was successful: " + model.toString());

          return new ResponseEntity<>(modelRepository.save(model), HttpStatus.OK);
        })
        .orElseThrow(() -> new ModelNotFoundException(id));
  }

  public ResponseEntity<HttpStatus> deleteModelById(Long id) {
    if (!modelRepository.existsById(id)) {
      logger.warn("model with id" + id + " will be removed from the Database ");
      throw new ModelNotFoundException(id);
    }

    modelRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  public ResponseEntity<HttpStatus> deleteALLModels() {
    List<Model> result = modelRepository.findAll();

    if (result.isEmpty())
      throw new ModelNotFoundException();
    logger.warn("Delete all Models!!! ");
    modelRepository.deleteAll();

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  private VehicleBrand checkifVehicleBrandExist(Long id) {
    Optional<VehicleBrand> vehicleBrand = vehicleBrandsRepository.findById(id);

    if (!vehicleBrandsRepository.existsById(id)) {
      logger.warn("model with id" + id + " will be removed from the Database ");
      throw new VehicleBrandNotFoundException(id);
    }
    // if (!vehicleBrand.isPresent()) {
    // logger.error("could not found vehicleBrand with id " + id);
    // throw new VehicleBrandNotFoundException(id);
    // }
    logger.info(" found vehicleBrand with id " + id);
    return vehicleBrand.get();
  }
}
