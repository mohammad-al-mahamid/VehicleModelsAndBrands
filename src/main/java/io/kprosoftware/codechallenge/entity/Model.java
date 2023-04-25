package io.kprosoftware.codechallenge.entity;

import javax.persistence.Entity;

import io.kprosoftware.codechallenge.common.BaseEntity;

@Entity
public class Model extends BaseEntity<Long> {

  private String name;
  private double enginePower;

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

}
