package com.codurance.streetplanning.counters;

import com.codurance.streetplanning.housenumbers.HouseNumbers;

public class OddHouseNumberCounter implements HousesCounter {
    @Override
    public int count(HouseNumbers houseNumbers) {
        return houseNumbers.countOdd();
    }
}
