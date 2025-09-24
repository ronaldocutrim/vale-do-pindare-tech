package com.ronaldocutrim.event_manager.core.controller.event;

import java.time.LocalDate;

public record EventInput(
        String name,
        String description,
        LocalDate date,
        Integer slots,
        String location,
        String ownerId) {
}
