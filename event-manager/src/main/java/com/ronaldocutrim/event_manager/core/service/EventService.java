package com.ronaldocutrim.event_manager.core.service;

import com.ronaldocutrim.event_manager.core.model.EventModel;
import com.ronaldocutrim.event_manager.core.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final ParticipantService participantService;
    private final RegistrationService registrationService;

    public List<EventModel> getNextEvents() {
        return eventRepository.findByDateAfterAndActiveTrue(LocalDate.now());
    }

    public EventModel findById(String id) {
        return eventRepository.findByIdAndActiveTrue(id).orElse(null);
    }

    public EventOutput getEvent(String id, String participantId) {
        var event = eventRepository.findById(id).orElseThrow();
        var output = EventOutput
                .builder()
                .withId(event.getId().toString())
                .withName(event.getName())
                .withDescription(event.getDescription())
                .withLocation(event.getLocation())
                .withSlots(event.getSlots())
                .withDate(event.getDate());
        if(Objects.equals(participantId, event.getParticipant().getId().toString())) {
            var registrations = registrationService.findByEventId(id);
            var participants = participantService.findByIds(registrations.stream().map(r -> r.getParticipant().getId().toString()).toList());
            output.withParticipants(participants.stream().map(participant ->
                    EventOutput.ParticipantOutput.builder()
                            .withName(participant.getName())
                            .withEmail(participant.getEmail())
                            .build()
            ).toList());
        }
        return output.build();
    }

    @Transactional
    public void save(EventInput eventInput) {
        var event = new EventModel();
        var existsParticipant = participantService.findOrCreate(eventInput.participantName(), eventInput.participantEmail());
        event.setName(eventInput.name());
        event.setDescription(eventInput.description());
        event.setDate(eventInput.date());
        event.setLocation(eventInput.location());
        event.setSlots(eventInput.slots());
        event.setParticipant(existsParticipant);
        eventRepository.save(event);
    }
}


