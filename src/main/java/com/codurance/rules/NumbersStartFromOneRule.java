package com.codurance.rules;

import java.util.List;

public class NumbersStartFromOneRule implements ValidationRule {
    @Override
    public boolean validate(List<Integer> numberSequence) {
        return numberSequence.stream().findFirst().get() == 1;
    }
}
