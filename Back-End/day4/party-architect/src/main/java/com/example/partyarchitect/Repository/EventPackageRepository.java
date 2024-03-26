package com.example.partyarchitect.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.partyarchitect.Model.EventPackage;

@Repository
public interface EventPackageRepository extends JpaRepository<EventPackage, Long> {
}
