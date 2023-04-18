package com.rokada.transformers.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementResponseWrapper {

  private List<ElementDtoResponse> elements;

}
