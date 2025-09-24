package com.ronaldocutrim.event_manager.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@Builder(builderClassName = "builder", setterPrefix = "with")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "event_date", nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    @Column(name = "total_slots", nullable = false)
    private Integer slots;

    @Column(nullable = false)
    private Boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private ParticipantModel participant;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegistrationModel> registrations;
}
