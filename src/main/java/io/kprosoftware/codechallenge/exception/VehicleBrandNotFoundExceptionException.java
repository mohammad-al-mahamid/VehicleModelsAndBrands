package io.kprosoftware.codechallenge.exception;

public class VehicleBrandNotFoundExceptionException extends RuntimeException {

  public VehicleBrandNotFoundExceptionException() {
    super();
  }

  public VehicleBrandNotFoundExceptionException(Long id) {
    super("Can not Found VehicleBrands with: ");
  }
}
