package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

@Component
public class AtLeastOneSpecialCharacterRule implements PasswordRule {
//    private static final String SPECIAL_CHARACTERS_REGEX = ".*[!@#$%&*()_+=|<>?{}\\[\\]~^].*";

    private static final String SPECIAL_CHARACTERS_REGEX = ".*[!@#$%^&*()\\-+].*";

    @Override
    public boolean validate(final String password) {
        return password != null
                && !password.trim().isEmpty()
                && password.matches(SPECIAL_CHARACTERS_REGEX);
    }
}
