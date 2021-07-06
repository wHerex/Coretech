package com.wherex.coretech.Event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String subject;
    private LocalDate startDateTime;
    private Long eventLength;
    private String description;

    public Event(String subject, LocalDate startDateTime, Long eventLength, String eventDescription) {
        this.subject = subject;
        this.startDateTime = startDateTime;
        this.eventLength = eventLength;
        this.description = eventDescription;
    }
}
