package com.rokada.transformers.service;

import com.rokada.transformers.model.ElementResponse;
import com.rokada.transformers.model.ElementWrapper;

public interface TransformationService {

  /**
   * Do the {@link ElementWrapper} data transformation based on transformers.
   *
   * @param elementWrapper data to transform along with transformers
   * @return {@link ElementResponse}
   */
  ElementResponse processData(ElementWrapper elementWrapper);
}
