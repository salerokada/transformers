package com.rokada.transformers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementDtoResponse {

  private String original;
  private String transformed;

}
