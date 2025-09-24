package com.ronaldocutrim.event_manager.core.controller.participant;

import lombok.Builder;

@Builder(builderClassName = "builder", setterPrefix = "with")
public record ParticipantOutput(String id, String name, String email) {
}