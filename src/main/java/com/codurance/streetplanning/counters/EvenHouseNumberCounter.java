package com.codurance.streetplanning.counters;

import com.codurance.streetplanning.housenumbers.HouseNumbers;

public class EvenHouseNumberCounter implements HousesCounter {
    @Override
    public int count(HouseNumbers houseNumbers) {
        return (int) houseNumbers.get().stream()
                .filter(houseNumber -> houseNumber % 2 == 0)
                .count();
    }
}
