package com.wherex.coretech.Event;

import com.wherex.coretech.User.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDto {
    private String id;
    private String subject;
    private String startDateTime;
    private long eventLength;
    private User owner;
    private String eventDescription;

}
