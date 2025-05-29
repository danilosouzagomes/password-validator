package com.itau.passwordvalidator.application.port;

public interface PasswordValidatorUseCase {

    boolean isValid(final String password);

}
