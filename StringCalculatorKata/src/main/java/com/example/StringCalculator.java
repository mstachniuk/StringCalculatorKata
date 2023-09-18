package com.example;

public class StringCalculator {
  public static String add(String input) {
    if (input.isEmpty()) {
      return "0";

    }
    if (!input.contains(",")) {
      return input;
    }

    return "0";
  }
}
