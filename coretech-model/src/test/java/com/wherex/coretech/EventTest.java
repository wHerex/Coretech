package com.wherex.coretech;

import com.wherex.coretech.Event.Event;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;


public class EventTest {

    @Test
    public void test() {
        //given
        Event event = new Event(UUID.randomUUID().toString(), "Subject", LocalDate.of(2021, 7, 1), 8L, "Description");

    }
}
