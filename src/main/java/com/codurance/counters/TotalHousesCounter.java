package com.codurance.counters;

import com.codurance.housenumbers.HouseNumbers;

public class TotalHousesCounter implements HousesCounter {

    @Override
    public int count(HouseNumbers houseNumbers) {
        return houseNumbers.get().size();
    }
}
