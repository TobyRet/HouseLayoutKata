package com.codurance.counters;

import com.codurance.housenumbers.HouseNumbers;

public class EvenHouseNumberCounter implements HousesCounter {
    @Override
    public int count(HouseNumbers houseNumbers) {
        return (int) houseNumbers.get().stream()
                .filter(houseNumber -> houseNumber % 2 == 0)
                .count();
    }
}
