package com.codurance.rules;

import java.util.List;

public class ValidationRules {

    private List<ValidationRule> validationRules;

    public ValidationRules(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<ValidationRule> get() {
        return validationRules;
    }
}
