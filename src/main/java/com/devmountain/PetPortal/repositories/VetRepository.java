package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {

    @Query(value = "SELECT * FROM vet v JOIN pet_profile p ON p.current_vet=v.vet_id WHERE p.pet_id = :pet_id", nativeQuery = true)
    Optional<Vet> findVetByPetId(Integer pet_id);

}
