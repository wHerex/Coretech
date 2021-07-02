package com.wherex.coretech.Event;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    public List<EventDto> getEvents() {
        return List.of(
                new EventDto(UUID.randomUUID().toString(), "Subject", LocalDate.of(2021, 7, 1), 8L, "Description"),
                new EventDto(UUID.randomUUID().toString(), "Subject", LocalDate.of(2021, 7, 11), 8L, "Description"),
                new EventDto(UUID.randomUUID().toString(), "Subject", LocalDate.of(2021, 7, 10), 8L, "Description")
        );
    }
}
