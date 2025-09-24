package com.ronaldocutrim.event_manager.core.service;

import com.ronaldocutrim.event_manager.core.model.ParticipantModel;
import com.ronaldocutrim.event_manager.core.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public List<ParticipantModel> findByIds(List<String> ids) {
        return participantRepository.findByIdIn(ids);
    }

    public ParticipantModel findOrCreate(String name, String email) {
        return participantRepository.findByEmail(email)
                .orElseGet(() -> {
                    ParticipantModel newParticipant = ParticipantModel.builder()
                            .withEmail(email)
                            .withName(name)
                            .build();
                    return participantRepository.save(newParticipant);
                });
    }
}
