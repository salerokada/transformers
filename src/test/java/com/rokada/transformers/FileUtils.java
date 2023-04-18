package com.rokada.transformers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static <T> T getFileAsClass(String filePath, Class<T> tClass) {
    objectMapper.registerModule(new JavaTimeModule());
    try {
      return objectMapper.readValue(getJsonFileAsString(filePath), tClass);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String getJsonFileAsString(String filePath) throws IOException {
    InputStream inputStream = getFilePath(filePath);
    JsonNode json = objectMapper.readValue(inputStream, JsonNode.class);
    return objectMapper.writeValueAsString(json);
  }

  private static InputStream getFilePath(String filePath) {
    return TypeReference.class
        .getResourceAsStream(filePath.startsWith("/") ? filePath
            : "/" + filePath);
  }
}