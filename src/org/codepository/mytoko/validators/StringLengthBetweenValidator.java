package org.codepository.mytoko.validators;

public class StringLengthBetweenValidator extends Validator {
    @Override
    public boolean validate() {
        return false;
    }

    public boolean validate(String input, int min, int max) {
        return min <= input.length() && input.length() <= max;
    }
}
