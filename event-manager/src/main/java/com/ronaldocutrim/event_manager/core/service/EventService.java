package com.ronaldocutrim.event_manager.core.service;

import com.ronaldocutrim.event_manager.core.model.EventModel;
import com.ronaldocutrim.event_manager.core.model.ParticipantModel;
import com.ronaldocutrim.event_manager.core.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<EventModel> getNextEvents() {
        return eventRepository.findByDateAfterAndActiveTrue(LocalDate.now());
    }

    public EventModel findById(UUID id) {
        return eventRepository.findByIdAndActiveTrue(id).orElse(null);
    }

    public EventModel getEventById(UUID id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void save(String name, String description, LocalDate date, String location, Integer slots, ParticipantModel participant) {
        var event = new EventModel();
        event.setName(name);
        event.setDescription(description);
        event.setDate(date);
        event.setLocation(location);
        event.setSlots(slots);
        event.setParticipant(participant);
        eventRepository.save(event);
    }
}


