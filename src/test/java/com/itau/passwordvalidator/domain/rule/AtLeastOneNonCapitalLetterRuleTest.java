package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AtLeastOneNonCapitalLetterRuleTest {

    private final AtLeastOneNonCapitalLetterRule rule = new AtLeastOneNonCapitalLetterRule();

    @Test
    void shouldReturnTrueForAtLeastOneNonCapitalLetter() {
        Assertions.assertTrue(rule.validate("TESt"));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoNonCapitalLetter() {
        Assertions.assertFalse(rule.validate("TEST"));
    }
}
