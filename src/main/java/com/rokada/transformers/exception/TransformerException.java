package com.rokada.transformers.exception;

import com.rokada.transformers.model.ElementRequestWrapper;
import com.rokada.transformers.model.ElementResponseWrapper;
import lombok.Getter;

@Getter
public class TransformerException extends RuntimeException {

  // This is anti-pattern, but I don't know how to catch something from the annotation processing
  private final ElementRequestWrapper elementRequestWrapper;
  private final ElementResponseWrapper elementResponse;

  public TransformerException(String message, ElementRequestWrapper elementRequestWrapper,
      ElementResponseWrapper elementResponse) {
    super(message);
    this.elementRequestWrapper = elementRequestWrapper;
    this.elementResponse = elementResponse;
  }

}
