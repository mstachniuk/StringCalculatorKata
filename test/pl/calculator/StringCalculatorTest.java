package pl.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void shouldAddEmptyTextAndReturnZero() {
        // when
        int result = stringCalculator.add("");

        // then
        assertEquals(0, result);
    }

    @Test
    public void shouldAddTextWithOneAndReturnOne() {
        // when
        int result = stringCalculator.add("1");

        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldAddOneAndTwoAndReturnThree() {
        // when
        int result = stringCalculator.add("1,2");

        // then
        assertEquals(3, result);
    }

    @Test
    public void shouldAddMoreArguments() {
        // when
        int result = stringCalculator.add("1,2,3,4");

        // then
        assertEquals(10, result);
    }

    @Test
    public void shouldAcceptNeLinesAsSeparator() {
        // when
        int result = stringCalculator.add("1\n2,3");

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldChangeDelimiter() {
        // when
        int result = stringCalculator.add("//;\n1;2");

        // then
        assertEquals(3, result);
    }

    @Test
    public void shouldThrowExceptionWhenNegative() {
        try {
            // when
            stringCalculator.add("-1,2");
        } catch (Exception e) {
           // then
            assertEquals("negatives not allowed: [-1]", e.getMessage());
        }
    }

    @Test
    public void shouldIgnoreNumbersBiggerThan1000() {
        // when
        int result = stringCalculator.add("2,1001");

        // then
        assertEquals(2, result);
    }


    @Test
    public void shouldAcceptLongerDelimiter() {
        // when
        int result = stringCalculator.add("//[***]\n1***2***3");

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldAllowMultipleDelimiters() {
        // when
        int result = stringCalculator.add("//[*][%]\n1*2%3");

        // then
        assertEquals(6, result);
    }

    @Test
    public void shouldAllowMultipleDelimitersWithLengthLongerThanOneChar() {
        // when
        int result = stringCalculator.add("//[**][%%]\n1**2%%3");

        // then
        assertEquals(6, result);
    }


}
