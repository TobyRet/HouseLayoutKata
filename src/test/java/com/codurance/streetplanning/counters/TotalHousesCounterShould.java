package com.codurance.streetplanning.counters;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TotalHousesCounterShould {

    @Test
    public void countTheTotalNumberOfHouses() {
        TotalHousesCounter totalHousesCounter = new TotalHousesCounter();
        HouseNumbers houseNumbers = new HouseNumbers(asList(1, 2, 3, 4, 5));
        assertThat(totalHousesCounter.count(houseNumbers), is(5));
    }
}
