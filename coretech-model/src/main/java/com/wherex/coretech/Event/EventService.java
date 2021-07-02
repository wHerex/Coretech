package com.wherex.coretech.Event;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    public List<EventDto> getEvents() {
        String date1 = LocalDate.of(2021, 7, 1).toString();
        String date2 = LocalDate.of(2021, 7, 11).toString();
        String date3 = LocalDate.of(2021, 7, 10).toString();
        return List.of(
                new EventDto(UUID.randomUUID().toString(), "Subject", date1, 8L, "Description"),
                new EventDto(UUID.randomUUID().toString(), "Subject", date2, 8L, "Description"),
                new EventDto(UUID.randomUUID().toString(), "Subject", date3, 8L, "Description")
        );
    }
}
