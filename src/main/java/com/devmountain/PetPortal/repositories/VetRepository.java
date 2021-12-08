package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {
}
