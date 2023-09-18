package com.example;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

  @ParameterizedTest
  @MethodSource
  void shouldReturnSingleDigit(String input, String expected) {
    String result = StringCalculator.add(input);

    assertEquals(expected, result);
  }

  static List<Arguments> shouldReturnSingleDigit() {
    return List.of(Arguments.of("0", "0"),
      Arguments.of("", "0"),
      Arguments.of("1", "1"),
      Arguments.of("2", "2"));
  }


}
