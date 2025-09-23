package com.ronaldocutrim.event_manager.core.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participants")
public class ParticipantModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
}
