package com.wherex.coretech.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Event {
    private String id;
    private String subject;
    private LocalDate startDateTime;
    private long eventLength;
    private String eventDescription;
}
