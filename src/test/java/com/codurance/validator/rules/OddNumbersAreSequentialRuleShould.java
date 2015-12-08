package com.codurance.validator.rules;

import java.util.Arrays;
import java.util.List;
import com.codurance.housenumbers.HouseNumbers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OddNumbersAreSequentialRuleShould {

    private OddNumbersAreSequentialRule oddNumbersAreSequentialRule;

    @Before
    public void setUp() {
        oddNumbersAreSequentialRule = new OddNumbersAreSequentialRule();
    }

    @Test
    public void returnFalseIfOddNumbersAreNonSequential() {
        List<Integer> nonSequentialOddNumbersList = Arrays.asList(1, 5, 2, 4, 3);

        assertThat(oddNumbersAreSequentialRule.validate(new HouseNumbers(nonSequentialOddNumbersList)), is(false));
    }

    @Test
    public void returnTrueIfOddNumbersAreSequential() {
        List<Integer> sequentialOddNumbersList = Arrays.asList(1, 2, 3, 5, 4);

        assertThat(oddNumbersAreSequentialRule.validate(new HouseNumbers(sequentialOddNumbersList)), is(true));
    }
}
