package com.rokada.transformers.service;

import com.rokada.transformers.enums.TransformerType;
import com.rokada.transformers.exception.BadRequestException;
import com.rokada.transformers.exception.DefaultException;
import com.rokada.transformers.model.ElementDto;
import com.rokada.transformers.model.ElementResponse;
import com.rokada.transformers.model.ElementWrapper;
import com.rokada.transformers.model.TransformerDto;
import com.rokada.transformers.util.Transliteration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class TransformationServiceImpl implements TransformationService {

  @Override
  public ElementResponse processData(ElementWrapper elementWrapper) {
    List<ElementDto> elements = elementWrapper.getElements();

    if (CollectionUtils.isEmpty(elements)) {
      return new ElementResponse(Collections.emptyMap());
    }

    Map<String, String> processedValues = elements.stream()
        .collect(Collectors.toMap(ElementDto::getValue, this::processElement));

    return new ElementResponse(processedValues);
  }

  private String processElement(ElementDto elementDto) {
    List<TransformerDto> transformers = elementDto.getTransformers();
    String processedValue = elementDto.getValue();

    for (TransformerDto transformer : transformers) {
      TransformerType transformerType = TransformerType.valueOf(transformer.getTransformerId());
      validateNumberOfParams(transformerType, transformer.getParameters());

      if (transformer.getTransformerId().equals(TransformerType.REMOVAL.name())) {
        processedValue = removal(processedValue, transformer.getParameters().get(0));
      }

      if (transformer.getTransformerId().equals(TransformerType.REPLACEMENT.name())) {
        processedValue = replacement(processedValue, transformer.getParameters().get(0),
            transformer.getParameters().get(1));
      }

      if (transformer.getTransformerId().equals(TransformerType.TRANSLITERATION.name())) {
        processedValue = translation(processedValue);
      }
    }

    return processedValue;
  }

  private String removal(String value, String strPattern) {
    return value.replaceAll(strPattern, "");
  }

  private String replacement(String value, String strPattern, String replacement) {
    return value.replaceAll(strPattern, replacement);
  }

  private String translation(String value) {
    String translated = value;
    translated = Transliteration.convertSerbianCyrillicToLatin(translated);
    translated = Transliteration.convertGreekToLatin(translated);
    return translated;
  }

  private void validateNumberOfParams(TransformerType transformerType, List<String> params) {
    switch (transformerType) {
      case REMOVAL, REPLACEMENT -> {
        if (CollectionUtils.isEmpty(params)
            || params.size() != transformerType.getNumberOfParams()) {
          throwParamsError(transformerType);
        }
      }
      case TRANSLITERATION -> {
      }
      default ->
          throw new DefaultException("There are not parameters rules applied for transformerType " + transformerType
              + ". Please contact administrator.");
    }


  }

  private void throwParamsError(TransformerType transformerType) {
    throw new BadRequestException(transformerType.name() + " needs to have "
        + TransformerType.REMOVAL.getNumberOfParams() + " parameters.");
  }
}
