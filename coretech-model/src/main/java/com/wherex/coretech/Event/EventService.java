package com.wherex.coretech.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public EventDto getEvent(String id){
        Event event = getEventFromRepo(id);
        return toDto(event);
    }

    public List<EventDto> getEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    public void saveEvent(EventDto eventDto) {
        Event event = toModel(eventDto);
        eventRepository.save(event);
    }

    public void deleteEvent(String id) {
       eventRepository.deleteById(id);
    }

    private EventDto toDto(Event event) {
        String eventId = event.getId();
        Long eventLength = event.getEventLength();
        String description = event.getDescription();
        String subject = event.getSubject();
        LocalDate startDateTime = event.getStartDateTime();
        String startDateTimeString = startDateTime.toString();
        return new EventDto(eventId, subject, startDateTimeString, eventLength, description);
    }

    private Event toModel(EventDto eventDto) {
        String subject = eventDto.getSubject();
        String startDateTimeString = eventDto.getStartDateTime();
        LocalDate startDateTime = LocalDate.parse(startDateTimeString);
        Long eventLength = eventDto.getEventLength();
        String description = eventDto.getEventDescription();
        return new Event(subject, startDateTime, eventLength, description);
    }

    private Event getEventFromRepo(String id) {
        return eventRepository.findById(id)
                .orElseThrow();
    }
}
