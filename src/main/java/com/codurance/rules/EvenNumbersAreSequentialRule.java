package com.codurance.rules;

import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbersAreSequentialRule implements ValidationRule {
    @Override
    public boolean validate(List<Integer> numberSequence) {
        List<Integer> oddNumbers = filterEvenNumbers(numberSequence);

        boolean isSequential = true;

        for (int i = 0; i < oddNumbers.size() - 1; i++) {
            if (oddNumbers.get(i) + 2 != oddNumbers.get(i + 1)) {
                isSequential = false;
            }
        }

        return isSequential;
    }

    private List<Integer> filterEvenNumbers(List<Integer> numberSequence) {
        return numberSequence
                .stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }
}
