package com.rokada.transformers.model;

import java.util.List;
import lombok.Data;

@Data
public class TransformerDto {

  private String group;
  private String transformerId;
  private List<String> parameters;
}
