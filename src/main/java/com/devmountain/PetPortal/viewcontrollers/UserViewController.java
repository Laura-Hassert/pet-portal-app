package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.User;
import com.devmountain.PetPortal.repositories.PetRepository;
import com.devmountain.PetPortal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

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
        return "userProfile";
    }

    @DeleteMapping("/deletePet")
    public String deletePet(@ModelAttribute Pet pet, Model model) {
        petRepository.delete(pet);
        model.addAttribute("pets", petRepository.findAll());
        return "userProfile";
    }

//    @PutMapping("/editPet")
//    public String editPet(@ModelAttribute Pet pet, Model model) {
//        petRepository.put(pet);
//        model.addAttribute("pets", petRepository.findAll());
//        return "petProfile";
//    }

    @GetMapping("/addNewPet")
    public String getAddNewPet() {
        return "addNewPet";
    }

}
