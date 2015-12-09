package com.codurance.streetplanning;

import com.codurance.streetplanning.counters.HouseNumbersPrinter;
import com.codurance.streetplanning.housenumbers.HouseNumbers;
import com.codurance.streetplanning.reader.HouseNumbersFileReader;
import com.codurance.streetplanning.validator.HouseNumbersValidator;

public class StreetPlanner {

    private final HouseNumbersFileReader houseNumbersFileReader;
    private final HouseNumbersValidator houseNumberValidator;
    private final HouseNumbersPrinter houseNumbersCounter;

    public StreetPlanner(
            HouseNumbersFileReader houseNumbersFileReader,
            HouseNumbersValidator houseNumberValidator,
            HouseNumbersPrinter houseNumbersCounter) {
        this.houseNumbersFileReader = houseNumbersFileReader;
        this.houseNumberValidator = houseNumberValidator;
        this.houseNumbersCounter = houseNumbersCounter;
    }

    public boolean isValid(String houseFilePath) {
        HouseNumbers houseNumbers = houseNumbersFileReader.read(houseFilePath);
        return houseNumberValidator.validate(houseNumbers);
    }

    public String countHouses(String houseFilePath) {
        HouseNumbers houseNumbers = houseNumbersFileReader.read(houseFilePath);

        return houseNumbersCounter.printCount(houseNumbers);
    }
}
