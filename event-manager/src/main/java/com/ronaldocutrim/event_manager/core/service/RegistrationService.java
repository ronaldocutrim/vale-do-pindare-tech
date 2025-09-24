package com.ronaldocutrim.event_manager.core.service;

import com.ronaldocutrim.event_manager.core.model.EventModel;
import com.ronaldocutrim.event_manager.core.model.ParticipantModel;
import com.ronaldocutrim.event_manager.core.model.RegistrationModel;
import com.ronaldocutrim.event_manager.core.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;

    public List<RegistrationModel> findByEventId(String eventId) {
        return registrationRepository.findByEventId(eventId).orElse(List.of());
    };

    @Transactional
    public void register(EventModel event, ParticipantModel participant) {
        var registrationModel = RegistrationModel.builder().withEvent(event).withParticipant(participant).build();
        registrationRepository.save(registrationModel);
    }
}
