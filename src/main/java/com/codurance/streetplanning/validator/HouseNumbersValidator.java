package com.codurance.streetplanning.validator;

import java.util.ArrayList;
import java.util.List;
import com.codurance.streetplanning.housenumbers.HouseNumbers;
import com.codurance.streetplanning.validator.rules.ValidationRules;

public class HouseNumbersValidator {
    private final ValidationRules validationRules;

    public HouseNumbersValidator(ValidationRules validationRules) {
        this.validationRules = validationRules;
    }


    public boolean validate(HouseNumbers houseNumbers) {
        List<Boolean> validationChecks = new ArrayList();

        validationRules.get().stream()
                .forEach(validationRule -> validationChecks.add(validationRule.validate(houseNumbers)));

        return !validationChecks.contains(false);
    }
}
