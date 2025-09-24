package com.ronaldocutrim.event_manager.core.repository;

import com.ronaldocutrim.event_manager.core.model.ParticipantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantModel, UUID> {
    Optional<ParticipantModel> findByEmail(String email);
    List<ParticipantModel> findByIdIn(List<UUID> ids);
}