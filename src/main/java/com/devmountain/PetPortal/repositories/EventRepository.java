package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value = "SELECT * FROM event e WHERE e.pet_id = :pet_id ORDER BY e.event_date DESC", nativeQuery = true)
    List<Event> findEventsByPetId(Integer pet_id);

}
