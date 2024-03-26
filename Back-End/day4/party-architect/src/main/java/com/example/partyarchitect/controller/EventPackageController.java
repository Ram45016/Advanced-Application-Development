package com.example.partyarchitect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.partyarchitect.Model.EventPackage;
import com.example.partyarchitect.Service.EventPackageService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event-packages")
public class EventPackageController {

    @Autowired
    private EventPackageService eventPackageService;

    @GetMapping
    public ResponseEntity<List<EventPackage>> getAllEventPackages() {
        List<EventPackage> eventPackages = eventPackageService.getAllEventPackages();
        return new ResponseEntity<>(eventPackages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventPackage> getEventPackageById(@PathVariable("id") Long id) {
        EventPackage eventPackage = eventPackageService.getEventPackageById(id);
        if (eventPackage != null) {
            return new ResponseEntity<>(eventPackage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<EventPackage> createEventPackage(@RequestBody EventPackage eventPackage) {
        EventPackage createdEventPackage = eventPackageService.saveOrUpdateEventPackage(eventPackage);
        return new ResponseEntity<>(createdEventPackage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventPackage> updateEventPackage(@PathVariable("id") Long id, @RequestBody EventPackage eventPackage) {
        eventPackage.setId(id);
        EventPackage updatedEventPackage = eventPackageService.saveOrUpdateEventPackage(eventPackage);
        return new ResponseEntity<>(updatedEventPackage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventPackage(@PathVariable("id") Long id) {
        eventPackageService.deleteEventPackage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
