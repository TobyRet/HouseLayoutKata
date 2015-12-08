package com.codurance.rules;

import java.util.List;

public interface ValidationRule {
    boolean validate(List<Integer> correctNumberSequence);
}
