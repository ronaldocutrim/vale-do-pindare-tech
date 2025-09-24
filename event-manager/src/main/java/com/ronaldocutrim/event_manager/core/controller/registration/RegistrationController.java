package com.ronaldocutrim.event_manager.core.controller.registration;

import com.ronaldocutrim.event_manager.core.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegistrationInput registrationInput) {
        registrationService.register(registrationInput);
    }
}
