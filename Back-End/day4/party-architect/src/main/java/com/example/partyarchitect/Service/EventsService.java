package com.example.partyarchitect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.partyarchitect.Model.Events;
import com.example.partyarchitect.Repository.EventsRepository;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Events getEventById(Long id) {
        return eventsRepository.findById(id).orElse(null);
    }

    public Events saveOrUpdateEvent(Events event) {
        return eventsRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }
}
