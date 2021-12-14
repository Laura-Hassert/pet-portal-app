package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.User;
import com.devmountain.PetPortal.repositories.PetRepository;
import com.devmountain.PetPortal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class UserViewController {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userProfile/{user_id}")
    public String getUserProfile(Model model, @PathVariable Integer user_id) {
        Optional<User> userOptional = userRepository.findById(user_id);
        userOptional.ifPresent(user -> {
            model.addAttribute("user", user);
        });

        List<Pet> petList = petRepository.findPetByUserId(user_id);
        model.addAttribute("pets", petList);

        return "userProfile";
    }

    @DeleteMapping("/deletePet/{petId}")
    public String deletePet(Model model, @PathVariable Integer petId, @RequestParam Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.ifPresent(user -> {
            Optional<Pet> petOptional = petRepository.findById(petId);
            petOptional.ifPresent(pet -> {
                user.getPets().remove(pet);
                pet.getUsers().remove(user);
                userRepository.save(user);
                petRepository.save(pet);
                userRepository.flush();
                petRepository.flush();
            });
            model.addAttribute("user", user);
        });

        model.addAttribute("pets", petRepository.findPetByUserId(userId));
        return "userProfile";
    }

    @PostMapping("/addNewPet/{userId}")
    public String submitNewPet(@ModelAttribute Pet pet, Model model, @PathVariable Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        userOptional.ifPresent(user -> {
            pet.setUsers(Collections.singletonList(user));
            user.getPets().add(pet);
            petRepository.save(pet);
            userRepository.save(user);
            petRepository.flush();
            userRepository.flush();
            model.addAttribute("user", user);
        });

        if(userOptional.isEmpty()) {
            model.addAttribute("user", new User());
        }

        model.addAttribute("pets", petRepository.findPetByUserId(userId));
        return "userProfile";
    }

    @GetMapping("/addNewPet/{userId}")
    public String getAddNewPet(Model model, @PathVariable Integer userId) {
        model.addAttribute("userId", userId);

        model.addAttribute("pet", new Pet());
        return "addNewPet";
    }

}
