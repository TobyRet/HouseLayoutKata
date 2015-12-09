package com.codurance.streetplanning.validator;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import com.codurance.streetplanning.validator.rules.ValidationRule;
import com.codurance.streetplanning.validator.rules.ValidationRules;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HouseNumberValidatorShould {

    private static final HouseNumbers HOUSE_NUMBERS = new HouseNumbers(asList(1, 2, 3, 4, 5));

    @Mock
    ValidationRule validation_rule_1;
    @Mock
    ValidationRule validation_rule_2;

    private HouseNumbersValidator houseNumberValidator;


    @Before
    public void initialise() {
        ValidationRules validationRules = new ValidationRules(asList(validation_rule_1, validation_rule_2));
        houseNumberValidator = new HouseNumbersValidator(validationRules);
    }

    @Test
    public void confirm_house_numbers_are_valid_when_all_rules_are_satisfied() {
        given(validation_rule_1.validate(HOUSE_NUMBERS)).willReturn(true);
        given(validation_rule_2.validate(HOUSE_NUMBERS)).willReturn(true);

        assertThat(houseNumberValidator.validate(HOUSE_NUMBERS), is(true));

        verify(validation_rule_1).validate(HOUSE_NUMBERS);
        verify(validation_rule_2).validate(HOUSE_NUMBERS);
    }

    @Test
    public void confirm_house_numbers_are_invalid_when_at_least_one_rule_is_not_satisfied() {
        given(validation_rule_1.validate(HOUSE_NUMBERS)).willReturn(true);
        given(validation_rule_2.validate(HOUSE_NUMBERS)).willReturn(false);

        assertThat(houseNumberValidator.validate(HOUSE_NUMBERS), is(false));

        verify(validation_rule_1).validate(HOUSE_NUMBERS);
        verify(validation_rule_2).validate(HOUSE_NUMBERS);
    }

}
