package com.codurance.streetplanning.validator.rules;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumbersAreUniqueRuleShould {

    private UniqueNumbersRule uniqueNumbersRule;

    @Before
    public void setUp() {
        uniqueNumbersRule = new UniqueNumbersRule();
    }

    @Test
    public void fails_if_house_numbers_are_not_unique() {
        HouseNumbers houseNumbers = new HouseNumbers(asList(1, 3, 3, 2, 4, 5));

        assertThat(uniqueNumbersRule.validate(houseNumbers), is(false));
    }

    @Test
    public void succeeds_if_house_numbers_are_unique() {
        HouseNumbers houseNumbers = new HouseNumbers(asList(1, 2, 3, 4, 5));

        assertThat(uniqueNumbersRule.validate(houseNumbers), is(true));
    }
}
