package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("select e from event e where e.pet_id = ?1 order by e.event_date desc")
    List<Event> findByPetId(Integer pet_id);

}
