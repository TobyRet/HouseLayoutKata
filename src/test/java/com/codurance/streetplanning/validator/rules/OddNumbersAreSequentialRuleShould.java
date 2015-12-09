package com.codurance.streetplanning.validator.rules;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OddNumbersAreSequentialRuleShould {

    private OddNumbersAreSequentialRule oddNumbersAreSequentialRule;

    @Before
    public void setUp() {
        oddNumbersAreSequentialRule = new OddNumbersAreSequentialRule();
    }

    @Test
    public void fails_when_odd_numbers_are_non_sequential() {
        HouseNumbers nonSequentialHouseNumbers = new HouseNumbers(asList(1, 5, 2, 4, 3));

        assertThat(oddNumbersAreSequentialRule.validate(nonSequentialHouseNumbers), is(false));
    }

    @Test
    public void succeeds_when_odd_numbers_are_sequential() {
        HouseNumbers sequentialHouseNumbers = new HouseNumbers(asList(1, 2, 3, 4, 5));

        assertThat(oddNumbersAreSequentialRule.validate(sequentialHouseNumbers), is(true));
    }
}
