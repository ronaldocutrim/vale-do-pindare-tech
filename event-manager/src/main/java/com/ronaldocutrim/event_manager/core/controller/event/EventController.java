package com.ronaldocutrim.event_manager.core.controller.event;

import com.ronaldocutrim.event_manager.core.model.EventModel;
import com.ronaldocutrim.event_manager.core.service.EventService;
import com.ronaldocutrim.event_manager.core.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;
    private final ParticipantService participantService;

    @GetMapping
    List<EventModel> getNextEvents() {
        return eventService.getNextEvents();
    }

    @GetMapping("/{id}")
    EventOutput getEvent(@PathVariable UUID id, @RequestParam(required = false) UUID participantId) {
        var event = eventService.getEventById(id);
        var output = EventOutput
                .builder()
                .withId(event.getId().toString())
                .withName(event.getName())
                .withDescription(event.getDescription())
                .withLocation(event.getLocation())
                .withSlots(event.getSlots())
                .withDate(event.getDate());

        if(participantId != null && Objects.equals(participantId, event.getParticipant().getId())) {
            output.withParticipants(event.getRegistrations().stream()
                    .map(registration -> EventOutput.ParticipantOutput.builder()
                            .withName(registration.getParticipant().getName())
                            .withEmail(registration.getParticipant().getEmail())
                            .build())
                    .toList());
        }
        return output.build();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody EventInput eventInput) {
        var participant = participantService.findById(UUID.fromString(eventInput.ownerId()));
        eventService.save(
                eventInput.name(),
                eventInput.description(),
                eventInput.date(),
                eventInput.location(),
                eventInput.slots(),
                participant
        );
    }
}
