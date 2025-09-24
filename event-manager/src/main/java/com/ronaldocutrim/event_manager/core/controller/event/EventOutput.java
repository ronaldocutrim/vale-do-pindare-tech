package com.ronaldocutrim.event_manager.core.controller.event;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Builder(builderClassName = "builder", setterPrefix = "with")
public record EventOutput(
        String id,
        String name,
        String description,
        String location,
        LocalDate date,
        Integer slots,
        List<ParticipantOutput> participants
) {
    @Builder(builderClassName = "builder", setterPrefix = "with")
    public record ParticipantOutput(String name, String email) {
    }
}
