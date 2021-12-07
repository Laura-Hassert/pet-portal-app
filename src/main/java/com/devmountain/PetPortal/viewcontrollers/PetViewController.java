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

    @GetMapping("/vet")
    public String getVetProfile(Model model) {
        Optional<Vet> vetOptional = vetRepository.findById(1);
        vetOptional.ifPresent(vet -> model.addAttribute("vet", vet));
        return "vetProfile";
    }

    @GetMapping("/entry")
    public String getEvent(Model model) {
        Optional<Event> eventOptional = eventRepository.findById(1);
        eventOptional.ifPresent(event -> model.addAttribute("event", event));
        return "event";
    }

    @GetMapping("/addNewVet")
    public String getAddNewVet() { return "addNewVet"; }

    @GetMapping("/addNewEntry")
    public String getAddNewEntry() { return "addNewEntry"; }

    @PostMapping("/addNewPet")
    public String newPetSubmit(@ModelAttribute Pet pet, Model model) {
        model.addAttribute("pet", pet);
        return "result";
    }

    @PostMapping("/addNewEntry")
    public String newEntrySubmit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "result";
    }

    @PostMapping("/addNewVet")
    public String newVetSubmit(@ModelAttribute Vet vet, Model model) {
        model.addAttribute("vet", vet);
        return "result";
    }

}
