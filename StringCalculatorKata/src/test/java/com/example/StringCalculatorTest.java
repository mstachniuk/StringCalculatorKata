package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
  @Test
  void shouldReturnZeroForEmptyInput() {
    String result = StringCalculator.add("");

    assertEquals("0", result);
  }
  @Test
  void shouldReturnSingleDigit() {
    String result = StringCalculator.add("1");

    assertEquals("1", result);
  }


}
