package com.devmountain.PetPortal.repositories;

import com.devmountain.PetPortal.models.Event;
import com.devmountain.PetPortal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from user_info u where u.email = ?1")
    User findByEmail(String email);

}
