package com.codurance.streetplanning.acceptance;

import java.util.List;
import com.codurance.streetplanning.StreetPlanner;
import com.codurance.streetplanning.reader.HouseNumbersFileReader;
import com.codurance.streetplanning.validator.HouseNumbersValidator;
import com.codurance.streetplanning.validator.rules.EvenNumbersAreSequentialRule;
import com.codurance.streetplanning.validator.rules.NumbersStartFromOneRule;
import com.codurance.streetplanning.validator.rules.OddNumbersAreSequentialRule;
import com.codurance.streetplanning.validator.rules.UniqueNumbersRule;
import com.codurance.streetplanning.validator.rules.ValidationRule;
import com.codurance.streetplanning.validator.rules.ValidationRules;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StreetPlannerShould {

    private static final String VALID_HOUSE_NUMBERS_FILE = "validHouseNumbers.txt";
    private static final String INVALID_HOUSE_NUMBERS_FILE = "invalidHouseNumbers.txt";
    private List<ValidationRule> validationRulesList;
    private ValidationRules validationsRules;
    private HouseNumbersValidator houseNumberValidator;
    private HouseNumbersFileReader houseNumbersFileReader;
    private StreetPlanner streetPlanner;

    @Before
    public void setup() {
        validationRulesList = asList(
                new EvenNumbersAreSequentialRule(),
                new NumbersStartFromOneRule(),
                new OddNumbersAreSequentialRule(),
                new UniqueNumbersRule());

        validationsRules = new ValidationRules(validationRulesList);
        houseNumberValidator = new HouseNumbersValidator(validationsRules);
        houseNumbersFileReader = new HouseNumbersFileReader();
        streetPlanner = new StreetPlanner(houseNumbersFileReader, houseNumberValidator);
    }

    @Test
    public void confirm_when_a_house_file_is_valid() {
        String pathToFile = VALID_HOUSE_NUMBERS_FILE;

        assertThat(streetPlanner.isValid(pathToFile), is(true));
    }

    @Test
    public void confirm_when_a_house_file_is_invalid() {
        String pathToFile = INVALID_HOUSE_NUMBERS_FILE;

        assertThat(streetPlanner.isValid(pathToFile), is(false));
    }

    @Test
    public void count_total_houses_in_a_file() {
        String pathToFile = VALID_HOUSE_NUMBERS_FILE;

        assertThat(streetPlanner.countTotalHouses(pathToFile), is(5));
    }

    @Test
    public void count_even_houses_in_a_file() {
        String pathToFile = VALID_HOUSE_NUMBERS_FILE;

        assertThat(streetPlanner.countEvenNumberHouses(pathToFile), is(2));
    }

    @Test
    public void count_odd_houses_in_a_file() {
        String pathToFile = VALID_HOUSE_NUMBERS_FILE;

        assertThat(streetPlanner.countOddNumberHouses(pathToFile), is(3));
    }
}
