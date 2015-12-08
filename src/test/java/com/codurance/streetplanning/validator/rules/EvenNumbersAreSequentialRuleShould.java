package com.codurance.streetplanning.validator.rules;

import java.util.List;
import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EvenNumbersAreSequentialRuleShould {

    private EvenNumbersAreSequentialRule evenNumbersAreSequentialRule;

    @Before
    public void setUp() {
        evenNumbersAreSequentialRule = new EvenNumbersAreSequentialRule();
    }

    @Test
    public void returnFalseIfOddNumbersAreNonSequential() {
        List<Integer> nonSequentialEvenNumbersList = asList(1, 3, 4, 2, 5);

        assertThat(evenNumbersAreSequentialRule.validate(new HouseNumbers(nonSequentialEvenNumbersList)), is(false));
    }

    @Test
    public void returnTrueIfOddNumbersAreSequential() {
        List<Integer> sequentialEvenNumbersList = asList(1, 3, 2, 4, 5);

        assertThat(evenNumbersAreSequentialRule.validate(new HouseNumbers(sequentialEvenNumbersList)), is(true));
    }
}
