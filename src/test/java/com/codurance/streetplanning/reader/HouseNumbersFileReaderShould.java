package com.codurance.streetplanning.reader;

import com.codurance.streetplanning.housenumbers.HouseNumbers;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HouseNumbersFileReaderShould {

    @Test
    public void convert_a_file_to_a_HouseNumbers_object() {
        HouseNumbersFileReader houseNumbersFileReader = new HouseNumbersFileReader();
        String pathToFile = "validHouseNumbers.txt";
        HouseNumbers expectedHouseNumbers = new HouseNumbers(asList(1, 2, 3, 4, 5));

        assertThat(houseNumbersFileReader.read(pathToFile), is(expectedHouseNumbers));
    }
}
