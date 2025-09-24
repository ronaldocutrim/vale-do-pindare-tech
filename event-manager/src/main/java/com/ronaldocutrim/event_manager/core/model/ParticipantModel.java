package com.ronaldocutrim.event_manager.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "participants")
@Builder(builderClassName = "builder", setterPrefix = "with")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EventModel> ownedEvents;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegistrationModel> registrations;
}
