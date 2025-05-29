package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumLengthRuleTest {

    private MinimumLengthRule rule = new MinimumLengthRule();

    @Test
    void shouldReturnTrueWhenMinimumLengthIsCorrect() {
        Assertions.assertTrue(rule.validate("123456789"));
    }

    @Test
    void shouldReturnFalseWhenMinimumLengthIsNotCorrect() {
        Assertions.assertFalse(rule.validate("12345678"));
    }
}
