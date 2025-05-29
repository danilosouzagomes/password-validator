package com.itau.passwordvalidator.domain.rule;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class NoRepeatedCharactersRule implements PasswordRule{
    @Override
    public boolean validate(final String password) {
        return password != null
                && !password.trim().isEmpty()
                && checkRepeatedCharacters(password);
    }

    private boolean checkRepeatedCharacters(final String password) {
        Set<Character> chars = new HashSet<>();
        for (char c : password.toCharArray()) {
            if (!chars.add(c)) {
                return false;
            }
        }
        return true;
    }
}
