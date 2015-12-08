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
