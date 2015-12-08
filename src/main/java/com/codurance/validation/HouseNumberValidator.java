package com.codurance.validation;

import java.util.ArrayList;
import java.util.List;
import com.codurance.housenumbers.HouseNumbers;
import com.codurance.rules.ValidationRules;

public class HouseNumberValidator {
    private final ValidationRules validationRules;

    public HouseNumberValidator(ValidationRules validationRules) {
        this.validationRules = validationRules;
    }


    public boolean validate(HouseNumbers houseNumbers){
        List<Boolean> validationChecks = new ArrayList();

        validationRules.get().stream()
                .forEach(validationRule -> validationChecks.add(validationRule.validate(houseNumbers.get())));

        return !validationChecks.contains(false);
    }
}
