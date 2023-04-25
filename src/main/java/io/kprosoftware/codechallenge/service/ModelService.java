package io.kprosoftware.codechallenge.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.exception.ModelNotFoundExceptionException;
import io.kprosoftware.codechallenge.repository.ModelRepository;

@Service
public class ModelService {
  private Logger logger;
  @Autowired
  private ModelRepository modelRepository;

  public ModelService(Logger logger) {
    super();
    this.logger = logger;
  }

  public List<Model> getModels() {
    List<Model> models = modelRepository.findAll();
    if (models.isEmpty()) {
      logger.info("Model List is Empty");
    }
    logger.info("Get a list of models");
    return models;
  }

  public Model getModelById(Long id) {
    Model result = modelRepository.findById(id).get();

    return result;
  }

  public Model addModel(Model Models) {
    Model newModels = modelRepository.saveAndFlush(Models);
    logger.info("Saved Models with id" + newModels.getId());
    logger.info("Models saved" + newModels.toString());
    modelRepository.saveAndFlush(newModels);
    return newModels;
  }

  public Model UpdateModel(Model newModels, Long id) {
    return modelRepository.findById(id)
        .map(model -> {
          logger.info("old Models: " + modelRepository.findById(id).get());
          model.setName(newModels.getName());
          model.setEnginePower(newModels.getEnginePower());

          logger.info("Update was successful: " + model.toString());
          return modelRepository.save(model);
        })
        .orElseThrow(() -> new ModelNotFoundExceptionException(id));
  }

  public void deleteModelById(Long id) {
    Optional<Model> result = modelRepository.findById(id);

    if (result.isPresent()) {
      logger.warn("Models with id" + id + " will be removed from the Database ");
      modelRepository.deleteById(id);
    } else {
      throw new ModelNotFoundExceptionException(id);
    }
  }

  public void deleteALLModels() {
    List<Model> result = modelRepository.findAll();

    if (result.isEmpty())
      throw new ModelNotFoundExceptionException();
    logger.warn("Delete ALL Models!!! ");
    modelRepository.deleteAll();
  }
}
