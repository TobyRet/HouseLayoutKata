package com.codurance.validator.rules;

import com.codurance.housenumbers.HouseNumbers;

public interface ValidationRule {
    boolean validate(HouseNumbers numberSequence);
}
