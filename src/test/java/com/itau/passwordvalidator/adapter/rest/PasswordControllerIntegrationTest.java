package com.itau.passwordvalidator.adapter.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PasswordControllerIntegrationTest {
    
    private static final String CONTROLLER_URI = "/api/v1/passwords/validate";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnFalseWhenThereIsNoCapitalLetterOnPassword() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("abtp9!fok"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoNonCapitalLetterOnPassword() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("ABTP9!FOK"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoDigitOnPassword() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("ABTPx!FOK"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenThereIsNoSpecialCharacterOnPassword() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("ABTP9xFOK"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenThereIsRepeatedCharactersOnPassword() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("Abtp9!fokA"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenPasswordShorterThanExpected() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("Ab!9"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenThereAreSpacesWithinThePassword() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("AbTp 9!fok"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturnFalseWhenPasswordAreOnlySpaces() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content(" "))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    void shouldReturn400WhenPasswordIsEmpty() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() throws Exception {
        mockMvc.perform(post(CONTROLLER_URI)
                        .contentType("text/plain")
                        .content("AbTp9!fok"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
