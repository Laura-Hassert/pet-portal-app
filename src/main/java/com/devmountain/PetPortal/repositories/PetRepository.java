package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{

//    @Modifying
//    @Query(value = "SELECT p FROM pet_profile p JOIN user_pet u ON p.pet_id=u.pet_id WHERE user_id = ?1")
//    List<Pet> findByUserId(Integer pet_id);
}
