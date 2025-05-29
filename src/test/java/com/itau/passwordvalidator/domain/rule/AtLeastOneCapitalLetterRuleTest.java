package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AtLeastOneCapitalLetterRuleTest {

    private final AtLeastOneCapitalLetterRule rule = new AtLeastOneCapitalLetterRule();

    @Test
    void shouldReturnTrueForAtLeastOneCapitalLetter() {
        Assertions.assertTrue(rule.validate("Test"));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoCapitalLetter() {
        Assertions.assertFalse(rule.validate("test"));
    }
}
