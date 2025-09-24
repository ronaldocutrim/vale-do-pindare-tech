package com.ronaldocutrim.event_manager.core.repository;

import com.ronaldocutrim.event_manager.core.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<EventModel, UUID> {
    Optional<EventModel> findByIdAndActiveTrue(UUID id);
    List<EventModel> findByDateAfterAndActiveTrue(LocalDate now);
}