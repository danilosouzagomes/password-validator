package com.itau.passwordvalidator.adapter.rest;

import com.itau.passwordvalidator.application.port.PasswordValidatorUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordController {

    private final PasswordValidatorUseCase service;

    public PasswordController(PasswordValidatorUseCase service) {
        this.service = service;
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestBody String password) {
        return ResponseEntity.ok(service.isValid(password));
    }

}
