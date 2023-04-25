package io.kprosoftware.codechallenge.exception;

public class VehicleBrandNotFoundException extends RuntimeException {

  public VehicleBrandNotFoundException() {
    super();
  }

  public VehicleBrandNotFoundException(Long id) {
    super("Can not Found VehicleBrands with: " + id);
  }
}
