package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
