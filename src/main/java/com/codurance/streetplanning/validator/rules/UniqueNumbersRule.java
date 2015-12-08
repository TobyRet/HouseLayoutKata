package com.codurance.streetplanning.validator.rules;

import java.util.HashSet;
import java.util.Set;
import com.codurance.streetplanning.housenumbers.HouseNumbers;

public class UniqueNumbersRule implements ValidationRule {
    @Override
    public boolean validate(HouseNumbers houseNumbers) {
        Set<Integer> numberSequenceToSet = new HashSet<>(houseNumbers.get());

        return numberSequenceToSet.size() == houseNumbers.get().size();
    }
}
