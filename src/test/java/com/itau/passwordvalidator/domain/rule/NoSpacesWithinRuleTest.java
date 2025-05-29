package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NoSpacesWithinRuleTest {

    private final NoSpacesWithinRule rule = new NoSpacesWithinRule();

    @Test
    void shouldReturnTrueWhenThereAreNoSpacesWithinThePassword() {
        Assertions.assertTrue(rule.validate("password"));
    }

    @Test
    void shouldReturnFalseWhenThereAreSpacesWithinThePassword() {
        Assertions.assertFalse(rule.validate("pass word"));
    }
}
