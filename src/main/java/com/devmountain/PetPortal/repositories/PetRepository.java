package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{
}
