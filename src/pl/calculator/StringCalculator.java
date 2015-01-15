package pl.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String delimiter = "[\n,]";
        String textNumbers = s;
        if (s.startsWith("//")) {
            Pattern pattern = Pattern.compile("//\\[[(\\w\\W)]*\\]\n");
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                String separatorsAsText = matcher.group();
                Pattern insidePattern = Pattern.compile("\\[[\\w\\W]*?\\]");
                Matcher innerMatcher = insidePattern.matcher(separatorsAsText);
                List<String> separators = new ArrayList<>();
                while (innerMatcher.find()) {
                    String separator = innerMatcher.group();
                    separator = separator.substring(1, separator.indexOf("]"));
                    separators.add(Pattern.quote(separator));
                }

                if (separators.size() == 1) {
                    delimiter = separators.get(0);
                } else {
                    delimiter = "[";
                    for (String separator : separators) {
                        delimiter = delimiter + "(" + separator + ")";
                    }
                    delimiter += "]";
                }
                textNumbers = s.substring(separatorsAsText.indexOf("\n") + 1);
            } else {
                delimiter = s.substring(2, 3);
                textNumbers = s.substring(4, s.length());
            }
        }

        String[] numbers = textNumbers.split(delimiter);
        numbers = ignoreEmptyNumbers(numbers);
        checkNegatives(numbers);
        int result = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 1000) {
                result += num;
            }
        }
        return result;
    }

    private String[] ignoreEmptyNumbers(String[] numbers) {
        List<String> result = new ArrayList<>();
        for (String number : numbers) {
            if (!number.isEmpty()) {
                result.add(number);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private void checkNegatives(String[] numbers) {
        List<String> negatives = new ArrayList<>();
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                negatives.add(number);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }
    }
}
