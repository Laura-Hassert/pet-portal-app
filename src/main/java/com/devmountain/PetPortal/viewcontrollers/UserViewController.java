package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Event;
import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.User;
import com.devmountain.PetPortal.repositories.PetRepository;
import com.devmountain.PetPortal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserViewController {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userProfile")
    public String getUserProfile(Model model) {
        Optional<User> userOptional = userRepository.findById(1);
        userOptional.ifPresent(user -> model.addAttribute("user", user));

//        List<Pet> petList = petRepository.findByUserId(1);
//        model.addAttribute("pets", petList);

        Optional<Pet> petOptional = petRepository.findById(1);
        petOptional.ifPresent(pet -> model.addAttribute("pet", pet));

        return "userProfile";
    }

    @DeleteMapping("/deletePet")
    public String deletePet(@ModelAttribute Pet pet, Model model) {
        petRepository.delete(pet);
        model.addAttribute("pets", petRepository.findAll());
        return "userProfile";
    }

    @PostMapping("/addNewPet")
    public String newPetSubmit(@ModelAttribute Pet pet, Model model) {
        model.addAttribute("pet", pet);
        petRepository.saveAndFlush(pet);
        return "userProfile";
    }

    @GetMapping("/addNewPet")
    public String getAddNewPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "addNewPet";
    }

}
