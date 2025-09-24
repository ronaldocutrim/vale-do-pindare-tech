package com.ronaldocutrim.event_manager.core.controller.event;

import com.ronaldocutrim.event_manager.core.model.EventModel;
import com.ronaldocutrim.event_manager.core.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    @GetMapping
    List<EventModel> getNextEvents() {
        return eventService.getNextEvents();
    }

    @GetMapping("/{id}")
    EventOutput getEvent(@PathVariable String id) {
        throw new RuntimeException("Not implemented yet");
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody EventInput eventInput) {
        eventService.save(eventInput);
    }
}
