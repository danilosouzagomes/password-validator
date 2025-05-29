package com.itau.passwordvalidator.domain.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AtLeastOneSpecialCharacterRuleTest {

    private final AtLeastOneSpecialCharacterRule rule = new AtLeastOneSpecialCharacterRule();

    private static final String TEST_STRING = "testString";

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+"})
    void shouldReturnTrueWhenAtLeastOneSpecialCharacterIsPresent(String character) {
        Assertions.assertTrue(rule.validate(TEST_STRING + character));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoSpecialCharacter() {
        Assertions.assertFalse(rule.validate(TEST_STRING));
    }
}
