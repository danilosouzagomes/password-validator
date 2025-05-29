package com.itau.passwordvalidator.application.service;

import com.itau.passwordvalidator.application.port.PasswordValidatorUseCase;
import com.itau.passwordvalidator.domain.rule.PasswordRule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordValidatorService implements PasswordValidatorUseCase {

    private final List<PasswordRule> rules;

    public PasswordValidatorService(List<PasswordRule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean isValid(final String password) {
        return rules.stream().allMatch(rule -> rule.validate(password));
    }

}
