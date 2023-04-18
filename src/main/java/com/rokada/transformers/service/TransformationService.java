package com.rokada.transformers.service;

import com.rokada.transformers.model.ElementRequestWrapper;
import com.rokada.transformers.model.ElementResponseWrapper;

public interface TransformationService {

  /**
   * Do the {@link ElementRequestWrapper} data transformation based on transformers.
   *
   * @param elementRequestWrapper data to transform along with transformers
   * @return {@link ElementResponseWrapper}
   */
  ElementResponseWrapper processData(ElementRequestWrapper elementRequestWrapper);
}
