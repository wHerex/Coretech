package com.wherex.coretech.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventDto> getEvents(){
        return eventService.getEvents();
    }

    @PostMapping
    public void saveEvent(@RequestBody EventDto eventDto){
        eventService.saveEvent(eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id){
        eventService.deleteEvent(id);
    }
}
