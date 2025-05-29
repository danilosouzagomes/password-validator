package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

@Component
public class NoSpacesWithinRule implements PasswordRule{
    @Override
    public boolean validate(final String password) {
        return password != null
                && !password.trim().isEmpty()
                && password.trim().length() == password.trim().replaceAll("\\s+", "").length();
    }
}
