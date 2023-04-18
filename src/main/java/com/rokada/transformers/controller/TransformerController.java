package com.rokada.transformers.controller;

import com.rokada.transformers.interceptor.Transformer;
import com.rokada.transformers.model.ElementRequestWrapper;
import com.rokada.transformers.model.ElementResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transformer")
@Tag(
    name = "Transformer controller",
    description = "Endpoint doing transformation processing")
@RequiredArgsConstructor
public class TransformerController {


  @PostMapping
  @Transformer
  @Operation(summary = "Process transformation on input data and return original and processed data.")
  @ApiResponse(responseCode = "200", description = "Data is successfully transformed")
  public ResponseEntity<ElementResponseWrapper> elementTransformation(
      @Valid @RequestBody ElementRequestWrapper request) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .build();
  }
}

