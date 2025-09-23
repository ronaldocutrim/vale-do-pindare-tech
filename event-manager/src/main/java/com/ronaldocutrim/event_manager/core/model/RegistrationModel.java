package com.ronaldocutrim.event_manager.core.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "registrations")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate registeredAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    private EventModel event;

    @ManyToOne(optional = false)
    @JoinColumn(name = "participant_id", nullable = false)
    private ParticipantModel participant;
}
