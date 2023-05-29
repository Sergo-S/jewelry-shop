package com.example.jewerlyshop.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ShortLengthValidator implements ConstraintValidator<ShortLength, Short> {
    private int length;

    @Override
    public void initialize(ShortLength annotation) {
        length = annotation.value();
    }

    @Override
    public boolean isValid(Short value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        int absValue = Math.abs(value);
        int digitCount = String.valueOf(absValue).length();
        return digitCount == length;
    }
}
