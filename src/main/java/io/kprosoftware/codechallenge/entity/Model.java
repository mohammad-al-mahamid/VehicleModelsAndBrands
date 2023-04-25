package io.kprosoftware.codechallenge.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.kprosoftware.codechallenge.common.BaseEntity;

@Entity
public class Model extends BaseEntity<Long> {

  private String name;
  private double enginePower;
  @ManyToOne
  @JoinColumn(nullable = false)
  private VehicleBrand vehicleBrand;

  public Model() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(double enginePower) {
    this.enginePower = enginePower;
  }

  public VehicleBrand getVehicleBrand() {
    return vehicleBrand;
  }

  public void setVehicleBrand(VehicleBrand vehicleBrand) {
    this.vehicleBrand = vehicleBrand;
  }

  @Override
  public String toString() {
    return "Model [name=" + name + ", enginePower=" + enginePower + ", vehicleBrand=" + vehicleBrand + "]";
  }

}
