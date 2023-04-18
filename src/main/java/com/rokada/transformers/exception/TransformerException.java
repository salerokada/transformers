package com.rokada.transformers.exception;

import com.rokada.transformers.model.ElementResponse;
import com.rokada.transformers.model.ElementWrapper;
import lombok.Getter;

@Getter
public class TransformerException extends RuntimeException {

  // This is anti-pattern, but I don't know how to catch something from the annotation processing
  private final ElementWrapper elementWrapper;
  private final ElementResponse elementResponse;

  public TransformerException(String message, ElementWrapper elementWrapper, ElementResponse elementResponse) {
    super(message);
    this.elementWrapper = elementWrapper;
    this.elementResponse = elementResponse;
  }

}
