package com.codurance.validation;

import java.util.List;

public interface ValidationRule {
    boolean validate(List<Integer> correctNumberSequence);
}
