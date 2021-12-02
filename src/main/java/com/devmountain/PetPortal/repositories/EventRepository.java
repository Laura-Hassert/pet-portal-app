package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
