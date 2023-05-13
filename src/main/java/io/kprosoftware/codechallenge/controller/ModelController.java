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

import io.kprosoftware.codechallenge.entity.Model;
import io.kprosoftware.codechallenge.service.ModelService;

@RestController
public class ModelController {
  @Autowired
  private ModelService modelService;

  @GetMapping("/Models")
  public ResponseEntity<List<Model>> getModels() {
    List<Model> models = modelService.getModels();

    if (models.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(models, HttpStatus.OK);
  }

  @GetMapping("/Model{id}")
  public ResponseEntity<Model> getModelById(@PathVariable Long id) {
    Model result = modelService.getModelById(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("vehicleBrands/{vehicleBrandId}/model")
  public ResponseEntity<List<Model>> getAllModelsByvehicleBrandId(
      @PathVariable(value = "vehicleBrandId") Long vehicleBrandId) {

    List<Model> models = modelService.getAllModelsByvehicleBrandId(vehicleBrandId);
    return new ResponseEntity<>(models, HttpStatus.OK);
  }

  @PostMapping("vehicleBrands/{vehicleBrandId}/model")
  public ResponseEntity<Model> addModel(@PathVariable Long vehicleBrandId, @RequestBody Model model) {
    Model newModel = modelService.addModel(vehicleBrandId, model);
    return new ResponseEntity<>(newModel, HttpStatus.CREATED);
  }

  @PutMapping("/Model/{id}")
  public ResponseEntity<Model> UpdateModel(@PathVariable Long id, @RequestBody Model model) {
    Model UpdatedModel = modelService.UpdateModel(model, id);
    return new ResponseEntity<>(UpdatedModel, HttpStatus.OK);
  }

  @DeleteMapping("/Model/{id}")
  public ResponseEntity<HttpStatus> deleteModelById(@PathVariable Long id) {
    modelService.deleteModelById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/Models")
  public ResponseEntity<HttpStatus> deleteModels() {
    modelService.deleteALLModels();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }
}
