package com.wherex.coretech.Event;

import com.wherex.coretech.User.User;
import com.wherex.coretech.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
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
        User owner = event.getOwner();
        String startDateTimeString = startDateTime.toString();

        return new EventDto(eventId, subject, startDateTimeString, eventLength, owner, description);
    }

    private Event toModel(EventDto eventDto) {
        String subject = eventDto.getSubject();
        String startDateTimeString = eventDto.getStartDateTime();
        LocalDate startDateTime = LocalDate.parse(startDateTimeString);
        Long eventLength = eventDto.getEventLength();
        String description = eventDto.getEventDescription();
        User owner = eventDto.getOwner();
        User existingOwner = userRepository.findByLogin(owner.getLogin())
                .orElseThrow();
        return new Event(subject, startDateTime, eventLength, existingOwner, description);
    }

    private Event getEventFromRepo(String id) {
        return eventRepository.findById(id)
                .orElseThrow();
    }
}
