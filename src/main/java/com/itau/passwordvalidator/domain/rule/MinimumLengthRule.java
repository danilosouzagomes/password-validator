package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

@Component
public class MinimumLengthRule implements PasswordRule {
    private static final int MINIMUM_LENGTH = 8;

    @Override
    public boolean validate(final String password) {
        return password != null
                && password.trim().length() > MINIMUM_LENGTH;
    }
}
