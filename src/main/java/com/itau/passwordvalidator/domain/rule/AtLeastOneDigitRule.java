package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

@Component
public class AtLeastOneDigitRule implements PasswordRule {
    private static final String DIGIT_REGEX = ".*\\d.*";

    @Override
    public boolean validate(final String password) {
        return password != null
                && !password.trim().isEmpty()
                && password.matches(DIGIT_REGEX);
    }
}
