package io.kprosoftware.codechallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  public List<Model> getModels() {
    return modelService.getModels();
  }

  @GetMapping("/Models{id}")
  public Model getModelById(@PathVariable Long id) {
    return modelService.getModelById(id);
  }

  @PostMapping("/Model")
  public Model addModel(@RequestBody Model Model) {
    return modelService.addModel(Model);
  }

  @PutMapping("/Model/{id}")
  public Model UpdateModel(@PathVariable Long id, @RequestBody Model Model) {
    return modelService.UpdateModel(Model, id);
  }

  @DeleteMapping("/Model/{id}")
  public void deleteModelById(@PathVariable Long id) {
    modelService.deleteModelById(id);
  }

  @DeleteMapping("/Models")
  public void deleteModels() {
    modelService.deleteALLModels();
  }
}
