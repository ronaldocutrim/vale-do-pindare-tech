package com.ronaldocutrim.event_manager.core.controller.registration;

import com.ronaldocutrim.event_manager.core.service.EventService;
import com.ronaldocutrim.event_manager.core.service.ParticipantService;
import com.ronaldocutrim.event_manager.core.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final EventService eventService;
    private final ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody RegistrationInput registrationInput) {
        var participant = participantService.findOrCreate(registrationInput.name(), registrationInput.email());
        var event = eventService.findById(UUID.fromString(registrationInput.eventId()));
        registrationService.register(event, participant);
    }
}
