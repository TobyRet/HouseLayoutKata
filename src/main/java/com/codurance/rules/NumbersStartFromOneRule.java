package com.codurance.rules;

import com.codurance.housenumbers.HouseNumbers;

public class NumbersStartFromOneRule implements ValidationRule {
    @Override
    public boolean validate(HouseNumbers houseNumbers) {
        return houseNumbers.get().stream().findFirst().get() == 1;
    }
}
