package com.example.partyarchitect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.partyarchitect.Model.Events;
import com.example.partyarchitect.Service.EventsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping("/GET")
    public ResponseEntity<List<Events>> getAllEvents() {
        List<Events> events = eventsService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("getid/{id}")
    public ResponseEntity<Events> getEventById(@PathVariable("id") Long id) {
        Events event = eventsService.getEventById(id);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {
        Events createdEvent = eventsService.saveOrUpdateEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Events> updateEvent(@PathVariable("id") Long id, @RequestBody Events event) {
        event.setId(id);
        Events updatedEvent = eventsService.saveOrUpdateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long id) {
        eventsService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
