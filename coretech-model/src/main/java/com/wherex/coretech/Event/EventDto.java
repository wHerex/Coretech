package com.wherex.coretech.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {
    private String id;
    private String subject;
    private String startDateTime;
    private long eventLength;
    private String eventDescription;

}
