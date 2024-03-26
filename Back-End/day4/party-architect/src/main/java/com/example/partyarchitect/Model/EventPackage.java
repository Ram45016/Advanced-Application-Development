package com.example.partyarchitect.Model;

import com.example.partyarchitect.Model.Events;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
public class EventPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String packageName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Events event;

    public EventPackage() {
    }

    public EventPackage(Long id, String packageName, double price, Events event) {
        this.id = id;
        this.packageName = packageName;
        this.price = price;
        this.event = event;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }
}
