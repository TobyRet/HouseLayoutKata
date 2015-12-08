package com.codurance.rules;

import java.util.HashSet;
import java.util.Set;
import com.codurance.housenumbers.HouseNumbers;

public class UniqueNumbersRule implements ValidationRule {
    @Override
    public boolean validate(HouseNumbers houseNumbers) {
        Set<Integer> numberSequenceToSet = new HashSet<>(houseNumbers.get());

        return numberSequenceToSet.size() == houseNumbers.get().size();
    }
}
