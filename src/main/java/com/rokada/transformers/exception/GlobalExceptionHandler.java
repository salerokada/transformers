package com.rokada.transformers.exception;

import com.rokada.transformers.model.ElementResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@ResponseBody
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {TransformerException.class})
  public ElementResponse handleTransformerException(TransformerException ex) {
    log.error("TransformerException message: {}", ex.getMessage());

    return ex.getElementResponse();
  }

  @ExceptionHandler(value = {BadRequestException.class})
  public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
    log.error("BadRequestException message: {}", ex.getMessage());

    return ResponseEntity
        .badRequest()
        .body(ex.getMessage());
  }

  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
    log.error("IllegalArgumentException occurred: ", ex);

    return ResponseEntity
        .internalServerError()
        .body(ex.getMessage());
  }
}