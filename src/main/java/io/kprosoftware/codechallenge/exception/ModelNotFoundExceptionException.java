package io.kprosoftware.codechallenge.exception;

public class ModelNotFoundExceptionException extends RuntimeException {

  public ModelNotFoundExceptionException() {
    super();
  }

  public ModelNotFoundExceptionException(Long id) {
    super("Can not Found model with Id: " + id);
  }
}
