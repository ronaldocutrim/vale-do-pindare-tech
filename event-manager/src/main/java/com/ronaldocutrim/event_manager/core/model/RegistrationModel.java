package com.ronaldocutrim.event_manager.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "registrations")
@Builder(builderClassName = "builder", setterPrefix = "with")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
