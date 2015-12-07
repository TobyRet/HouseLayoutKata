package com.codurance;

import java.util.List;

public interface ValidationRule {
    boolean validate(List<Integer> correctNumberSequence);
}
