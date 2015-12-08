package com.codurance.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueNumbersRule implements ValidationRule {
    @Override
    public boolean validate(List<Integer> numberSequence) {
        Set<Integer> numberSequenceToSet = new HashSet<>(numberSequence);

        return numberSequenceToSet.size() == numberSequence.size();
    }
}
