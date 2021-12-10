package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{

    @Query(value = "SELECT * FROM pet_profile p JOIN user_pet up ON p.pet_id=up.pet_id WHERE user_id = :user_id", nativeQuery = true)
    List<Pet> findPetByUserId(Integer user_id);
}
