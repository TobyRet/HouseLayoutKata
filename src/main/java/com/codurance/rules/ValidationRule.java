package com.codurance.rules;

import java.util.List;
import com.codurance.housenumbers.HouseNumbers;

public interface ValidationRule {
    boolean validate(HouseNumbers numberSequence);
}
