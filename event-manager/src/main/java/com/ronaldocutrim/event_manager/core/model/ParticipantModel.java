package com.ronaldocutrim.event_manager.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
