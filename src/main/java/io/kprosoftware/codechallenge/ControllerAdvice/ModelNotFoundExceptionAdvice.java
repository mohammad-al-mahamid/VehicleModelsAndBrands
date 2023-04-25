package io.kprosoftware.codechallenge.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.kprosoftware.codechallenge.exception.ModelNotFoundException;

@ControllerAdvice
public class ModelNotFoundExceptionAdvice {
  @ResponseBody
  @ExceptionHandler(ModelNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String ModelNotFoundException(ModelNotFoundException exception) {
    return exception.getMessage();
  }
}
