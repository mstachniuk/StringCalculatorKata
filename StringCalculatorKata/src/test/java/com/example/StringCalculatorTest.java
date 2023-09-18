package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
  @Test
  void shouldReturnZeroForEmptyInput() {
    String result = StringCalculator.add("");

    assertEquals("0", result);
  }
}
