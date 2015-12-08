package com.codurance.streetplanning.validator.rules;

import com.codurance.streetplanning.housenumbers.HouseNumbers;

public interface ValidationRule {
    boolean validate(HouseNumbers numberSequence);
}
