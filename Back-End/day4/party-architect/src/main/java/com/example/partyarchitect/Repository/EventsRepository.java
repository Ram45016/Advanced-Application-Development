package com.example.partyarchitect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.partyarchitect.Model.Events;


@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {
}