package com.example.partyarchitect.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.partyarchitect.Model.EventPackage;
import com.example.partyarchitect.Repository.EventPackageRepository;

import java.util.List;

@Service
public class EventPackageService {

    @Autowired
    private EventPackageRepository eventPackageRepository;

    public List<EventPackage> getAllEventPackages() {
        return eventPackageRepository.findAll();
    }

    public EventPackage getEventPackageById(Long id) {
        return eventPackageRepository.findById(id).orElse(null);
    }

    public EventPackage saveOrUpdateEventPackage(EventPackage eventPackage) {
        return eventPackageRepository.save(eventPackage);
    }

    public void deleteEventPackage(Long id) {
        eventPackageRepository.deleteById(id);
    }
}
