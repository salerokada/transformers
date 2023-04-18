package com.rokada.transformers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.rokada.transformers.FileUtils;
import com.rokada.transformers.model.ElementRequestWrapper;
import com.rokada.transformers.model.ElementResponseWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransformationServiceImplTest {

  private TransformationService transformationService;

  @BeforeEach
  void setUp() {
    transformationService = new TransformationServiceImpl();
  }

  @Test
  void processDataCyrillic() {
    ElementRequestWrapper elementRequestWrapper = FileUtils.getFileAsClass(
        "service/elementRequestWrapperCyrillic.json", ElementRequestWrapper.class);
    ElementResponseWrapper expected = FileUtils.getFileAsClass(
        "service/elementResponseWrapperCyrillic.json", ElementResponseWrapper.class);

    ElementResponseWrapper result = transformationService.processData(elementRequestWrapper);

    assertNotNull(result);
    assertEquals(expected, result);
  }

  @Test
  void processDataGreece() {
    ElementRequestWrapper elementRequestWrapper = FileUtils.getFileAsClass(
        "service/elementRequestWrapperGreek.json", ElementRequestWrapper.class);
    ElementResponseWrapper expected = FileUtils.getFileAsClass(
        "service/elementResponseWrapperGreek.json", ElementResponseWrapper.class);

    ElementResponseWrapper result = transformationService.processData(elementRequestWrapper);

    assertNotNull(result);
    assertEquals(expected, result);
  }
}