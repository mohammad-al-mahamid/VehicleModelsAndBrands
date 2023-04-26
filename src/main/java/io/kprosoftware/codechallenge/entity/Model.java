package io.kprosoftware.codechallenge.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.kprosoftware.codechallenge.common.BaseEntity;

@Entity
public class Model extends BaseEntity<Long> {

  @NotNull(message = "Name cannot be null")
  @Size(max = 100, message = "Name must not exceed {value} characters")
  private String name;
  private double enginePower;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vehicleBrand_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private VehicleBrand vehicleBrand;

  public Model() {
    super();
  }

  public Model(String name, double enginePower, VehicleBrand vehicleBrand) {
    this.name = name;
    this.enginePower = enginePower;
    this.vehicleBrand = vehicleBrand;
  }

  public Model(String name, double enginePower) {
    this.name = name;
    this.enginePower = enginePower;
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
    return "Model [name=" + name + ", enginePower=" + enginePower + "]";
  }

}
