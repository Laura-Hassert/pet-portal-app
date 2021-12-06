package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Event;
import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.Vet;
import com.devmountain.PetPortal.repositories.EventRepository;
import com.devmountain.PetPortal.repositories.PetRepository;
import com.devmountain.PetPortal.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PetViewController {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private VetRepository vetRepository;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/petProfile")
    public String getPetProfile(Model model) {
        Optional<Pet> petOptional = petRepository.findById(1);
        petOptional.ifPresent(pet -> model.addAttribute("pet", pet));
        return "petProfile";
    }

//    @GetMapping("/vet")
//    public String getVetProfile(Model model) {
//        Optional<Vet> vetOptional = vetRepository.findById(?);
//        vetOptional.ifPresent(pet -> model.addAttribute("vet", vet));
//        return "vetProfile";
//    }
//
//    @GetMapping("/entry")
//    public String getEvent(Model model) {
//        Optional<Event> eventOptional = eventRepository.findById(?);
//        eventOptional.ifPresent(pet -> model.addAttribute("event", event));
//        return "event";
//    }

}
