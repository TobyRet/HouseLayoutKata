package com.codurance.streetplanning.counters;

import com.codurance.streetplanning.housenumbers.HouseNumbers;

public class TotalHousesCounter implements HousesCounter {

    @Override
    public int count(HouseNumbers houseNumbers) {
        return houseNumbers.countAll();
    }
}
