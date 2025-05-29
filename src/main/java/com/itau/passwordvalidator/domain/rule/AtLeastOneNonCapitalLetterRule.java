package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

@Component
public class AtLeastOneNonCapitalLetterRule implements PasswordRule {
    private static final String NON_CAPITAL_LETTER_REGEX = ".*[a-z].*";

    @Override
    public boolean validate(final String password) {
        return password != null
                && !password.trim().isEmpty()
                && password.matches(NON_CAPITAL_LETTER_REGEX);
    }
}
