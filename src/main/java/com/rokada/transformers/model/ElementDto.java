package com.rokada.transformers.model;

import java.util.List;
import lombok.Data;

@Data
public class ElementDto {

  private String value;
  private List<TransformerDto> transformers;
}
