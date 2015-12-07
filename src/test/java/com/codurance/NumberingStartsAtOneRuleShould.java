package com.codurance;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class NumberingStartsAtOneRuleShould {

    @Test
    public void returnTrueIfHouseNumberingStartsAtOne() {
        NumberStartsAtOneRule numberingStartsAtOneRule = new NumberStartsAtOneRule();

        List<Integer> correctNumberSequence = Arrays.asList(1, 3, 2, 5, 4);

        assertThat(numberingStartsAtOneRule.validate(correctNumberSequence), is(true));
    }

    @Test
    public void returnFalseIfHouseNumberingDoesNotStartAtOne() {
        NumberStartsAtOneRule numberingStartsAtOneRule = new NumberStartsAtOneRule();

        List<Integer> correctNumberSequence = Arrays.asList(3, 2, 5, 4);

        assertThat(numberingStartsAtOneRule.validate(correctNumberSequence), is(false));
    }
}
