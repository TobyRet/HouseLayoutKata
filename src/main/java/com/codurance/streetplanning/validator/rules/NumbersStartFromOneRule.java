package com.codurance.streetplanning.validator.rules;

import com.codurance.streetplanning.housenumbers.HouseNumbers;

public class NumbersStartFromOneRule implements ValidationRule {
    @Override
    public boolean validate(HouseNumbers houseNumbers) {
        return houseNumbers.get().stream().findFirst().get() == 1;
    }
}
