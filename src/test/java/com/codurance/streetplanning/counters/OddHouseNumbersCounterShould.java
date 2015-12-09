package com.codurance.streetplanning.counters;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OddHouseNumbersCounterShould {

    @Test
    public void count_odd_house_numbers() {
        OddHouseNumberCounter oddHouseNumberCounter = new OddHouseNumberCounter();
        HouseNumbers houseNumbers = new HouseNumbers(asList(1, 2, 3, 4, 5, 6, 7));

        assertThat(oddHouseNumberCounter.count(houseNumbers), is(4));
    }
}
