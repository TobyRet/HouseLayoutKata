package com.codurance.housenumbers;

import java.util.List;

public class HouseNumbers {
    private final List<Integer> houseNumbers;

    public HouseNumbers(List<Integer> houseNumbers) {
        this.houseNumbers = houseNumbers;
    }

    public List<Integer> get() {
        return houseNumbers;
    }
}
