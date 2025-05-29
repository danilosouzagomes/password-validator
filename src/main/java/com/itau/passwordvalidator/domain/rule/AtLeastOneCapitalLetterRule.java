package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

@Component
public class AtLeastOneCapitalLetterRule implements PasswordRule {
    private static final String CAPITAL_LETTER_REGEX = ".*[A-Z].*";

    @Override
    public boolean validate(final String password) {
        return password != null
                && !password.trim().isEmpty()
                && password.matches(CAPITAL_LETTER_REGEX);
    }
}
