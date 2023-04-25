package io.kprosoftware.codechallenge.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.kprosoftware.codechallenge.exception.VehicleBrandNotFoundException;

@ControllerAdvice
public class VehicleBrandNotFoundExceptionAdvice {

  @ResponseBody
  @ExceptionHandler(VehicleBrandNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String VehicleBrandNotFound(VehicleBrandNotFoundException exception) {
    return exception.getMessage();
  }
}
