package com.codurance.validator;

import java.util.List;
import com.codurance.housenumbers.HouseNumbers;
import com.codurance.rules.EvenNumbersAreSequentialRule;
import com.codurance.rules.NumbersStartFromOneRule;
import com.codurance.rules.OddNumbersAreSequentialRule;
import com.codurance.rules.UniqueNumbersRule;
import com.codurance.rules.ValidationRule;
import com.codurance.rules.ValidationRules;
import com.codurance.validation.HouseNumberValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class HouseNumberValidatorShould {

    @Mock
    EvenNumbersAreSequentialRule mockedEvenNumbersAreSequentialRule;

    @Mock
    NumbersStartFromOneRule mockedNumbersStartFromOneRule;

    @Mock
    OddNumbersAreSequentialRule mockedOddNumbersAreSequentialRule;

    @Mock
    UniqueNumbersRule mockedUniqueNumbersRule;

    @Mock
    ValidationRules validationRules;


    @Test
    public void returnFalseIfNumberSequenceInvalid() {
        HouseNumberValidator numberValidator = new HouseNumberValidator(validationRules);
        List<Integer> houseNumbersDoNotStartAtOne = asList(2, 4, 1, 3, 5);
        HouseNumbers houseNumbers = new HouseNumbers(houseNumbersDoNotStartAtOne);

        List<ValidationRule> mockedValidationRules = asList(
                mockedEvenNumbersAreSequentialRule,
                mockedNumbersStartFromOneRule,
                mockedOddNumbersAreSequentialRule,
                mockedUniqueNumbersRule);

        given(validationRules.get()).willReturn(mockedValidationRules);
        given(mockedNumbersStartFromOneRule.validate(houseNumbers)).willReturn(false);
        given(mockedOddNumbersAreSequentialRule.validate(houseNumbers)).willReturn(true);
        given(mockedEvenNumbersAreSequentialRule.validate(houseNumbers)).willReturn(true);
        given(mockedUniqueNumbersRule.validate(houseNumbers)).willReturn(true);

        assertThat(numberValidator.validate(houseNumbers), is(false));
    }

    @Test
    public void returnTrueIfNumberSequenceIsValid() {
        HouseNumberValidator numberValidator = new HouseNumberValidator(validationRules);
        List<Integer> houseNumbersDoNotStartAtOne = asList(2, 4, 1, 3, 5);
        HouseNumbers houseNumbers = new HouseNumbers(houseNumbersDoNotStartAtOne);

        List<ValidationRule> mockedValidationRules = asList(
                mockedEvenNumbersAreSequentialRule,
                mockedNumbersStartFromOneRule,
                mockedOddNumbersAreSequentialRule,
                mockedUniqueNumbersRule);

        given(validationRules.get()).willReturn(mockedValidationRules);
        given(mockedNumbersStartFromOneRule.validate(houseNumbers)).willReturn(true);
        given(mockedOddNumbersAreSequentialRule.validate(houseNumbers)).willReturn(true);
        given(mockedEvenNumbersAreSequentialRule.validate(houseNumbers)).willReturn(true);
        given(mockedUniqueNumbersRule.validate(houseNumbers)).willReturn(true);

        assertThat(numberValidator.validate(houseNumbers), is(true));
    }
}
