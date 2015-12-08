package com.codurance.streetplanning.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.codurance.streetplanning.housenumbers.HouseNumbers;

import static java.nio.file.Paths.get;

public class HouseNumbersFileReader {

    public HouseNumbers read(String houseNumbersFile) {
        Path path = get(houseNumbersFile);
        String[] houseNumbersStringArray = new String[0];

        try {
            houseNumbersStringArray = convertToStringArray(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new HouseNumbers(convertToIntegerList(houseNumbersStringArray));
    }

    private List<Integer> convertToIntegerList(String[] houseNumbersStringArray) {
        List<Integer> houseNumbersList = new ArrayList<>();

        for (String houseNumberAsString : houseNumbersStringArray) {
            houseNumbersList.add(Integer.valueOf(houseNumberAsString));
        }

        return houseNumbersList;
    }

    private String[] convertToStringArray(Path path) throws IOException {
        return Files.lines(path).findFirst().map(line -> line.split(" ")).get();
    }
}
