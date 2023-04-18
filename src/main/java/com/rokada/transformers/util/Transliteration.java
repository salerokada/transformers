package com.rokada.transformers.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Transliteration {

  private Transliteration() {
  }

  private static final Map<Character, String> serbianCyrillicToLatinMap;
  private static final Map<Character, String> greekToLatinMap;

  public static String convertSerbianCyrillicToLatin(String source) {
    return convert(source, serbianCyrillicToLatinMap);
  }

  public static String convertGreekToLatin(String source) {
    return convert(source, greekToLatinMap);
  }

  private static String convert(String source, Map<Character, String> languageToLatinMap) {
    var result = new StringBuilder();
    for (char c : source.toCharArray()) {
      Optional<String> translated = Optional.ofNullable(languageToLatinMap.get(c));
      result.append(translated.isPresent() ? translated.get() : c);
    }
    return result.toString();
  }

  static {
    serbianCyrillicToLatinMap = new HashMap<>();

    serbianCyrillicToLatinMap.put('а', "a");
    serbianCyrillicToLatinMap.put('б', "b");
    serbianCyrillicToLatinMap.put('в', "v");
    serbianCyrillicToLatinMap.put('г', "g");
    serbianCyrillicToLatinMap.put('д', "d");
    serbianCyrillicToLatinMap.put('ђ', "dj");
    serbianCyrillicToLatinMap.put('е', "e");
    serbianCyrillicToLatinMap.put('ж', "zh");
    serbianCyrillicToLatinMap.put('з', "z");
    serbianCyrillicToLatinMap.put('и', "i");
    serbianCyrillicToLatinMap.put('ј', "j");
    serbianCyrillicToLatinMap.put('к', "k");
    serbianCyrillicToLatinMap.put('л', "l");
    serbianCyrillicToLatinMap.put('љ', "lj");
    serbianCyrillicToLatinMap.put('м', "m");
    serbianCyrillicToLatinMap.put('н', "n");
    serbianCyrillicToLatinMap.put('њ', "nj");
    serbianCyrillicToLatinMap.put('о', "o");
    serbianCyrillicToLatinMap.put('п', "p");
    serbianCyrillicToLatinMap.put('р', "r");
    serbianCyrillicToLatinMap.put('с', "s");
    serbianCyrillicToLatinMap.put('т', "t");
    serbianCyrillicToLatinMap.put('ћ', "ch");
    serbianCyrillicToLatinMap.put('у', "u");
    serbianCyrillicToLatinMap.put('ф', "f");
    serbianCyrillicToLatinMap.put('х', "h");
    serbianCyrillicToLatinMap.put('ц', "c");
    serbianCyrillicToLatinMap.put('ч', "ch");
    serbianCyrillicToLatinMap.put('џ', "dz");
    serbianCyrillicToLatinMap.put('ш', "sh");
    serbianCyrillicToLatinMap.put('А', "A");
    serbianCyrillicToLatinMap.put('Б', "B");
    serbianCyrillicToLatinMap.put('В', "V");
    serbianCyrillicToLatinMap.put('Г', "G");
    serbianCyrillicToLatinMap.put('Д', "D");
    serbianCyrillicToLatinMap.put('Ђ', "Dj");
    serbianCyrillicToLatinMap.put('Е', "E");
    serbianCyrillicToLatinMap.put('Ж', "Zh");
    serbianCyrillicToLatinMap.put('З', "Z");
    serbianCyrillicToLatinMap.put('И', "I");
    serbianCyrillicToLatinMap.put('Ј', "J");
    serbianCyrillicToLatinMap.put('К', "K");
    serbianCyrillicToLatinMap.put('Љ', "L");
    serbianCyrillicToLatinMap.put('Л', "Lj");
    serbianCyrillicToLatinMap.put('М', "M");
    serbianCyrillicToLatinMap.put('Н', "N");
    serbianCyrillicToLatinMap.put('Њ', "Nj");
    serbianCyrillicToLatinMap.put('О', "O");
    serbianCyrillicToLatinMap.put('П', "P");
    serbianCyrillicToLatinMap.put('Р', "R");
    serbianCyrillicToLatinMap.put('С', "S");
    serbianCyrillicToLatinMap.put('Т', "T");
    serbianCyrillicToLatinMap.put('Ћ', "Ch");
    serbianCyrillicToLatinMap.put('У', "U");
    serbianCyrillicToLatinMap.put('Ф', "F");
    serbianCyrillicToLatinMap.put('Х', "H");
    serbianCyrillicToLatinMap.put('Ц', "C");
    serbianCyrillicToLatinMap.put('Ч', "Ch");
    serbianCyrillicToLatinMap.put('Џ', "Dz");
    serbianCyrillicToLatinMap.put('Ш', "Sh");
  }

  static {
    greekToLatinMap = new HashMap<>();

    serbianCyrillicToLatinMap.put('α', "a");
    serbianCyrillicToLatinMap.put('ά', "a");
    serbianCyrillicToLatinMap.put('β', "v");
    serbianCyrillicToLatinMap.put('γ', "g");
    serbianCyrillicToLatinMap.put('δ', "d");
    serbianCyrillicToLatinMap.put('ε', "e");
    serbianCyrillicToLatinMap.put('έ', "e");
    serbianCyrillicToLatinMap.put('ζ', "z");
    serbianCyrillicToLatinMap.put('η', "i");
    serbianCyrillicToLatinMap.put('ή', "i");
    serbianCyrillicToLatinMap.put('θ', "th");
    serbianCyrillicToLatinMap.put('ι', "i");
    serbianCyrillicToLatinMap.put('ϊ', "i");
    serbianCyrillicToLatinMap.put('ί', "i");
    serbianCyrillicToLatinMap.put('ΐ', "i");
    serbianCyrillicToLatinMap.put('κ', "k");
    serbianCyrillicToLatinMap.put('λ', "l");
    serbianCyrillicToLatinMap.put('μ', "m");
    serbianCyrillicToLatinMap.put('ν', "n");
    serbianCyrillicToLatinMap.put('ξ', "x");
    serbianCyrillicToLatinMap.put('ο', "o");
    serbianCyrillicToLatinMap.put('ό', "o");
    serbianCyrillicToLatinMap.put('π', "p");
    serbianCyrillicToLatinMap.put('ρ', "r");
    serbianCyrillicToLatinMap.put('σ', "s");
    serbianCyrillicToLatinMap.put('ς', "s");
    serbianCyrillicToLatinMap.put('τ', "t");
    serbianCyrillicToLatinMap.put('υ', "i");
    serbianCyrillicToLatinMap.put('ϋ', "i");
    serbianCyrillicToLatinMap.put('ύ', "i");
    serbianCyrillicToLatinMap.put('ΰ', "i");
    serbianCyrillicToLatinMap.put('φ', "ph");
    serbianCyrillicToLatinMap.put('χ', "kh");
    serbianCyrillicToLatinMap.put('ψ', "ps");
    serbianCyrillicToLatinMap.put('ω', "o");
    serbianCyrillicToLatinMap.put('ώ', "o");
    serbianCyrillicToLatinMap.put('Α', "A");
    serbianCyrillicToLatinMap.put('Ά', "A");
    serbianCyrillicToLatinMap.put('Β', "V");
    serbianCyrillicToLatinMap.put('Γ', "G");
    serbianCyrillicToLatinMap.put('Δ', "D");
    serbianCyrillicToLatinMap.put('Ε', "E");
    serbianCyrillicToLatinMap.put('Έ', "E");
    serbianCyrillicToLatinMap.put('Ζ', "Z");
    serbianCyrillicToLatinMap.put('Η', "I");
    serbianCyrillicToLatinMap.put('Ή', "I");
    serbianCyrillicToLatinMap.put('Θ', "TH");
    serbianCyrillicToLatinMap.put('Ι', "I");
    serbianCyrillicToLatinMap.put('Ί', "I");
    serbianCyrillicToLatinMap.put('Κ', "K");
    serbianCyrillicToLatinMap.put('Λ', "L");
    serbianCyrillicToLatinMap.put('Μ', "M");
    serbianCyrillicToLatinMap.put('Ν', "N");
    serbianCyrillicToLatinMap.put('Ξ', "X");
    serbianCyrillicToLatinMap.put('Ο', "O");
    serbianCyrillicToLatinMap.put('Ό', "O");
    serbianCyrillicToLatinMap.put('Π', "P");
    serbianCyrillicToLatinMap.put('Ρ', "R");
    serbianCyrillicToLatinMap.put('Σ', "S");
    serbianCyrillicToLatinMap.put('Τ', "T");
    serbianCyrillicToLatinMap.put('Υ', "I");
    serbianCyrillicToLatinMap.put('Ύ', "I");
    serbianCyrillicToLatinMap.put('Φ', "Ph");
    serbianCyrillicToLatinMap.put('Χ', "Kh");
    serbianCyrillicToLatinMap.put('Ψ', "Ps");
    serbianCyrillicToLatinMap.put('Ω', "O");
    serbianCyrillicToLatinMap.put('Ώ', "O");
  }
}
