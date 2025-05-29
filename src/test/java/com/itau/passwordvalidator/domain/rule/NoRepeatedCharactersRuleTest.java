package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NoRepeatedCharactersRuleTest {

    private final NoRepeatedCharactersRule rule = new NoRepeatedCharactersRule();

    @Test
    void shouldReturnTrueWhenThereAreNoRepeatedCharacters() {
        Assertions.assertTrue(rule.validate("abc"));
    }

    @Test
    void shouldReturnFalseWhenThereAreRepeatedCharacters() {
        Assertions.assertFalse(rule.validate("aabc"));
    }
}
