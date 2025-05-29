package com.itau.passwordvalidator.domain.rule;

@FunctionalInterface
public interface PasswordRule {

    boolean validate(final String password);

}
