package io.kprosoftware.codechallenge.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.kprosoftware.codechallenge.common.BaseEntity;
import io.kprosoftware.codechallenge.enum_.PriceSegment;

@Entity
public class VehicleBrand extends BaseEntity<Long> {
  @NotNull(message = "Name cannot be null")
  @Size(max = 100, message = "Name must not exceed {value} characters")
  private String name;
  @Enumerated(EnumType.STRING)
  private PriceSegment priceSegment;
  @OneToMany(mappedBy = "vehicleBrand", fetch = FetchType.LAZY)
  private List<Model> models;

  public VehicleBrand() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PriceSegment getPriceSegment() {
    return priceSegment;
  }

  public void setPriceSegment(PriceSegment priceSegment) {
    this.priceSegment = priceSegment;
  }

  public VehicleBrand(String name, PriceSegment priceSegment) {

    this.name = name;
    this.priceSegment = priceSegment;
  }

  public List<Model> getModels() {
    return models;
  }

  public void setModels(List<Model> models) {
    this.models = models;
  }

  public void addModel(Model model) {
    models.add(model);
  }

  @Override
  public String toString() {
    return "VehicleBrand [name=" + name + ", priceSegment=" + priceSegment + ", models=" + models + "]";
  }

}
