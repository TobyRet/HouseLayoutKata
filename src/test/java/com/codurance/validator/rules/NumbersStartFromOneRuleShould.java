package com.codurance.validator.rules;

import java.util.List;
import com.codurance.housenumbers.HouseNumbers;
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
    public void returnTrueIfHouseNumberingStartsAtOne() {
        List<Integer> correctNumberSequence = asList(1, 3, 2, 5, 4);

        assertThat(numberingStartsAtOneRule.validate(new HouseNumbers(correctNumberSequence)), is(true));
    }

    @Test
    public void returnFalseIfHouseNumberingDoesNotStartAtOne() {
        List<Integer> incorrectNumberSequence = asList(3, 2, 5, 4);

        assertThat(numberingStartsAtOneRule.validate(new HouseNumbers(incorrectNumberSequence)), is(false));
    }
}
