package com.ronaldocutrim.event_manager.core.repository;

import com.ronaldocutrim.event_manager.core.model.ParticipantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantModel, String> {
}