package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AtLeastOneDigitRuleTest {

    private final AtLeastOneDigitRule rule = new AtLeastOneDigitRule();

    @Test
    void shouldReturnTrueForAtLeastOneDigit() {
        Assertions.assertTrue(rule.validate("test8"));
    }

    @Test
    void shouldReturnFalseForNoDigit() {
        Assertions.assertFalse(rule.validate("test"));
    }
}
