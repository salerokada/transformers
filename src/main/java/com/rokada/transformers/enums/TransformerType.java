package com.rokada.transformers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransformerType {

  REMOVAL(1),
  REPLACEMENT(2),
  TRANSLITERATION(0);

  private final int numberOfParams;
}
