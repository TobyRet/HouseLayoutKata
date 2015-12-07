package com.codurance;

import java.util.List;

public class NumberStartsAtOneRule implements ValidationRule {
    @Override
    public boolean validate(List<Integer> numberSequence) {
        return numberSequence.stream().findFirst().get() == 1;
    }
}
