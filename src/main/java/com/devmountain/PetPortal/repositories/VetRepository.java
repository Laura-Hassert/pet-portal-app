package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Integer> {
}
