package io.kprosoftware.codechallenge.exception;

public class ModelNotFoundException extends RuntimeException {

  public ModelNotFoundException() {
    super();
  }

  public ModelNotFoundException(Long id) {
    super("Can not Found model with Id: " + id);
  }
}
