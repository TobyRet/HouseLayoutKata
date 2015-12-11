package com.codurance.streetplanning;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import com.codurance.streetplanning.reader.HouseNumbersFileReader;
import com.codurance.streetplanning.validator.HouseNumbersValidator;

public class StreetPlanner {

    private final HouseNumbersFileReader houseNumbersFileReader;
    private final HouseNumbersValidator houseNumberValidator;

    public StreetPlanner(
            HouseNumbersFileReader houseNumbersFileReader,
            HouseNumbersValidator houseNumberValidator) {
        this.houseNumbersFileReader = houseNumbersFileReader;
        this.houseNumberValidator = houseNumberValidator;
    }

    public boolean isValid(String houseFilePath) {
        HouseNumbers houseNumbers = houseNumbersFileReader.read(houseFilePath);
        return houseNumberValidator.validate(houseNumbers);
    }

    public int countTotalHouses(String houseFilePath) {
        HouseNumbers houseNumbers = houseNumbersFileReader.read(houseFilePath);
        return houseNumbers.countAll();
    }

    public int countEvenNumberHouses(String houseFilePath) {
        HouseNumbers houseNumbers = houseNumbersFileReader.read(houseFilePath);
        return houseNumbers.countEven();
    }

    public int countOddNumberHouses(String houseFilePath) {
        HouseNumbers houseNumbers = houseNumbersFileReader.read(houseFilePath);
        return houseNumbers.countOdd();
    }
}
