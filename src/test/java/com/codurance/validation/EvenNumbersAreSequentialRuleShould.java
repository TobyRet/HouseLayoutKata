package com.codurance.validation;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

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
        List<Integer> nonSequentialEvenNumbersList = Arrays.asList(1,3,4,2,5);

        assertThat(evenNumbersAreSequentialRule.validate(nonSequentialEvenNumbersList), is(false));
    }

    @Test
    public void returnTrueIfOddNumbersAreSequential() {
        List<Integer> sequentialEvenNumbersList = Arrays.asList(1,3,2,4,5);

        assertThat(evenNumbersAreSequentialRule.validate(sequentialEvenNumbersList), is(true));
    }
}
