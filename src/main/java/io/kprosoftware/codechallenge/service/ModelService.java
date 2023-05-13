package io.kprosoftware.codechallenge.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

  public List<Model> getModels() {
    List<Model> models = modelRepository.findAll();
    if (models.isEmpty()) {
      logger.info("Model List is Empty");
      return models;
    }
    logger.info("Get a list of models");
    return models;
  }

  public Model getModelById(Long id) {
    Model result = modelRepository.findById(id)
        .orElseThrow(() -> new ModelNotFoundException(id));

    logger.info("model with " + id + " is " + result);
    return result;
  }

  public List<Model> getAllModelsByvehicleBrandId(Long vehicleBrandId) {
    if (!vehicleBrandsRepository.existsById(vehicleBrandId)) {
      throw new VehicleBrandNotFoundException(vehicleBrandId);
    }

    List<Model> models = modelRepository.findByvehicleBrandId(vehicleBrandId);
    return models;
  }

  public Model addModel(Long vehicleBrandId, Model model) {
    VehicleBrand existingVehicleBrand = checkifVehicleBrandExist(vehicleBrandId);
    Model newModel = new Model(model.getName(), model.getEnginePower(), existingVehicleBrand);

    logger.info("Saved Models with id" + newModel.getId());
    logger.info("Models saved" + newModel.toString());

    modelRepository.saveAndFlush(newModel);

    return newModel;
  }

  public Model UpdateModel(Model newModel, Long id) {
    return modelRepository.findById(id)
        .map(model -> {
          logger.info("old Models: " + modelRepository.findById(id).get());
          model.setName(newModel.getName());
          model.setEnginePower(newModel.getEnginePower());

          logger.info("Update was successful: " + model.toString());

          return modelRepository.save(model);
        })
        .orElseThrow(() -> new ModelNotFoundException(id));
  }

  public Boolean deleteModelById(Long id) {
    if (!modelRepository.existsById(id)) {
      logger.warn("model with id" + id + " will be removed from the Database ");
      throw new ModelNotFoundException(id);
    }

    modelRepository.deleteById(id);
    return true;
  }

  public Boolean deleteALLModels() {
    List<Model> result = modelRepository.findAll();

    if (result.isEmpty())
      throw new ModelNotFoundException();
    logger.warn("Delete all Models!!! ");
    modelRepository.deleteAll();

    return true;
  }

  private VehicleBrand checkifVehicleBrandExist(Long id) {
    Optional<VehicleBrand> vehicleBrand = vehicleBrandsRepository.findById(id);

    if (!vehicleBrandsRepository.existsById(id)) {
      logger.warn("model with id" + id + " will be removed from the Database ");
      throw new VehicleBrandNotFoundException(id);
    }

    logger.info(" found vehicleBrand with id " + id);
    return vehicleBrand.get();
  }
}
