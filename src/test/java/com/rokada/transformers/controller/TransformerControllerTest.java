package com.rokada.transformers.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rokada.transformers.model.ElementRequestWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class TransformerControllerTest {

  private TransformerController transformerController;
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    transformerController = new TransformerController();

    mockMvc = MockMvcBuilders
        .standaloneSetup(transformerController)
        .build();
  }

  /**
   * Testing just endpoint address and default response
   */
  @Test
  void elementTransformation() throws Exception {
    ElementRequestWrapper elementRequestWrapper = new ElementRequestWrapper();

    mockMvc.perform(post("/v1/transformer")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(elementRequestWrapper)))
        .andDo(print())
        .andExpect(status().isOk());
  }
}