package com.devmountain.PetPortal.viewcontrollers;

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

    @GetMapping("/userProfile/{user_id}")
    public String getUserProfile(Model model, @PathVariable Integer user_id) {

        List<Pet> petList = petRepository.findPetByUserId(user_id);
        model.addAttribute("pets", petList);

        return "userProfile";
    }

    @DeleteMapping("/deletePet")
    public String deletePet(@ModelAttribute Pet pet, Model model) {
        petRepository.delete(pet);
        model.addAttribute("pets", petRepository.findAll());
        return "userProfile";
    }

    @PostMapping("/addNewPet")
    public String submitNewPet(@ModelAttribute Pet pet, Model model, @RequestParam Integer userId) {
        Optional<User> userPetOptional = userRepository.findById(userId);
        userPetOptional.ifPresent(user -> {
//            pet.setUsers(user);
            model.addAttribute("user", user);
        });

        if(userPetOptional.isEmpty()) {
            model.addAttribute("user", new User());
        }

        petRepository.saveAndFlush(pet);
        model.addAttribute("pets", petRepository.findPetByUserId(userId));
        return "userProfile";
    }

    @GetMapping("/addNewPet")
    public String getAddNewPet(Model model, @RequestParam Integer userId) {
        model.addAttribute("userId", userId);

        model.addAttribute("pet", new Pet());
        return "addNewPet";
    }

}
