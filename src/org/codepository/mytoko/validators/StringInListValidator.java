package org.codepository.mytoko.validators;

public class StringInListValidator extends Validator {
    @Override
    public boolean validate() {
        return false;
    }

    public boolean validate(String input, String[] list) {
        for (String compare :
                list) {
            if (input.equals(compare)) {
                return true;
            }
        }

        return false;
    }
}
