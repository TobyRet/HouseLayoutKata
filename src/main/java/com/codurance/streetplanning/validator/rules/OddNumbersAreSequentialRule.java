package com.codurance.streetplanning.validator.rules;

import com.codurance.streetplanning.housenumbers.HouseNumbers;

public class OddNumbersAreSequentialRule implements ValidationRule {
    @Override
    public boolean validate(HouseNumbers houseNumbers) {
        return houseNumbers.areSequential();


//        List<Integer> oddNumbers = filterOddNumbers(houseNumbers.get());
//
//        boolean areSequential = true;
//
//        for (int i = 0; i < oddNumbers.size() - 1; i++) {
//            if (oddNumbers.get(i) + 2 != oddNumbers.get(i + 1)) {
//                areSequential = false;
//            }
//        }
//
//        return areSequential;
    }

//    private List<Integer> filterOddNumbers(List<Integer> numberSequence) {
//        return numberSequence
//                .stream()
//                .filter(number -> number % 2 == 1)
//                .collect(Collectors.toList());
//    }
}
