package com.itau.passwordvalidator.application.service;

import com.itau.passwordvalidator.domain.rule.PasswordRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PasswordValidatorServiceTest {

    @Test
    void shouldReturnTrueWhenAllRulesAreValid() {
        PasswordRule rule = password -> true;

        PasswordValidatorService passwordValidatorService = new PasswordValidatorService(List.of(rule, rule));

        Assertions.assertTrue(passwordValidatorService.isValid("anyPassword"));
    }

    @Test
    void shouldReturnFalseWhenAnyRuleIsNotValid() {
        PasswordRule validRule = password -> true;
        PasswordRule invalidRule = password -> false;

        PasswordValidatorService passwordValidatorService = new PasswordValidatorService(List.of(validRule, invalidRule));

        Assertions.assertFalse(passwordValidatorService.isValid("anyPassword"));
    }
}
