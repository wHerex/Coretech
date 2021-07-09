package com.wherex.coretech;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wherex.coretech.Event.Event;
import com.wherex.coretech.Event.EventDto;
import com.wherex.coretech.User.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;


public class EventTest {

    @Test
    public void test() {
        ObjectMapper objectMapper = new ObjectMapper();
        String subject = "Subject";
        LocalDate localDate = LocalDate.now();
        Long eventLength = 8L;
        User owner = new User("user", "user", "USER");
        String description = "Description";
        EventDto event = new EventDto(UUID.randomUUID().toString() ,subject, localDate.toString(), eventLength, owner, description);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
