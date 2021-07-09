package com.wherex.coretech.Event;

import com.wherex.coretech.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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

    @OneToOne(fetch = FetchType.EAGER)
    private User owner;

    private String description;

    public Event(String subject, LocalDate startDateTime, Long eventLength, User owner, String description) {
        this.subject = subject;
        this.startDateTime = startDateTime;
        this.eventLength = eventLength;
        this.owner = owner;
        this.description = description;
    }
}
