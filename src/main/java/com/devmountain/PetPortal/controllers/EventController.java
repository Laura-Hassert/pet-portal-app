package com.devmountain.PetPortal.controllers;

import com.devmountain.PetPortal.models.Event;
import com.devmountain.PetPortal.repositories.EventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events/")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public List<Event> event() {
        return eventRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{event_id}")
    public Event get(@PathVariable Integer event_id) {
        return eventRepository.getById(event_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@RequestBody final Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @RequestMapping(value = "{event_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer event_id) {
        eventRepository.deleteById(event_id);
    }

    @RequestMapping(value = "{event_id}", method = RequestMethod.PUT)
    public Event update(@PathVariable Integer event_id, @RequestBody Event event) {
        Event existingEvent = eventRepository.getById(event_id);
        BeanUtils.copyProperties(event, existingEvent, "event_id");
        return eventRepository.saveAndFlush(existingEvent);
    }
}