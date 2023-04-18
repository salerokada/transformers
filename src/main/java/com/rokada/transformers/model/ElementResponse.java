package com.rokada.transformers.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ElementResponse {

  /**
   * Map contains original and transformed value.
   */
  private Map<String, String> processedElements;

}
