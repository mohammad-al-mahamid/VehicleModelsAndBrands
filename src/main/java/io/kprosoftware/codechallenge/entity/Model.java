package io.kprosoftware.codechallenge.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.kprosoftware.codechallenge.common.BaseEntity;

@Entity
public class Model extends BaseEntity<Long> {

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
