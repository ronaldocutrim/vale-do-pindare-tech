package com.ronaldocutrim.event_manager.core.controller.participant;

import com.ronaldocutrim.event_manager.core.model.ParticipantModel;
import com.ronaldocutrim.event_manager.core.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ParticipantOutput findOrCreate(@RequestBody ParticipantInput participantInput) {
        var participant = participantService.findOrCreate(participantInput.name(), participantInput.email());
        return ParticipantOutput.builder()
                .withId(participant.getId().toString())
                .withName(participant.getName())
                .withEmail(participant.getEmail())
                .build();
    }
}