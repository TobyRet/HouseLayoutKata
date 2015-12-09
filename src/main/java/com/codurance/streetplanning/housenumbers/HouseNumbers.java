package com.codurance.streetplanning.housenumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class HouseNumbers {
    private final List<Integer> houseNumbers;

    public HouseNumbers(List<Integer> houseNumbers) {
        this.houseNumbers = houseNumbers;
    }

    public List<Integer> get() {
        return houseNumbers;
    }

    public boolean areSequential() {
        Integer highestNumber = houseNumbers.stream().max((x, y) -> (x < y) ? -1 : 1).orElse(0);
        List<Integer> sequentialNumbers = range(1, highestNumber + 1).boxed().collect(Collectors.toList());
        return Arrays.equals(houseNumbers.toArray(), sequentialNumbers.toArray());
    }

    public int countAll() {
        return houseNumbers.size();
    }

    public int countEven() {
        return (int) houseNumbers.stream()
                .filter(houseNumber -> houseNumber % 2 == 0)
                .count();
    }

    public int countOdd() {
        return (int) houseNumbers.stream()
                .filter(houseNumber -> houseNumber % 2 == 1)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseNumbers that = (HouseNumbers) o;

        return !(houseNumbers != null ? !houseNumbers.equals(that.houseNumbers) : that.houseNumbers != null);

    }

    @Override
    public int hashCode() {
        return houseNumbers != null ? houseNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HouseNumbers{");
        sb.append("houseNumbers=").append(houseNumbers);
        sb.append('}');
        return sb.toString();
    }
}
