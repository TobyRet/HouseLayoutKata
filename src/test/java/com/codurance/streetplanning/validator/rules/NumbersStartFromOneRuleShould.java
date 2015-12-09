package com.codurance.streetplanning.validator.rules;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class NumbersStartFromOneRuleShould {

    private NumbersStartFromOneRule numberingStartsAtOneRule;

    @Before
    public void setUp() {
        numberingStartsAtOneRule = new NumbersStartFromOneRule();
    }

    @Test
    public void suceeds_if_house_numbers_start_from_one() {
        HouseNumbers houseNumbers = new HouseNumbers(asList(1, 3, 2, 5, 4));

        assertThat(numberingStartsAtOneRule.validate(houseNumbers), is(true));
    }

    @Test
    public void fails_if_house_numbers_do_not_start_from_one() {
        HouseNumbers houseNumbers = new HouseNumbers(asList(3, 2, 5, 4));

        assertThat(numberingStartsAtOneRule.validate(houseNumbers), is(false));
    }
}
