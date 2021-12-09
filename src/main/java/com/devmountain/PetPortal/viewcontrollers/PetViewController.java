package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Event;
import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.User;
import com.devmountain.PetPortal.models.Vet;
import com.devmountain.PetPortal.repositories.EventRepository;
import com.devmountain.PetPortal.repositories.PetRepository;
import com.devmountain.PetPortal.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

        Optional<Vet> vetOptional = vetRepository.findById(1);
        vetOptional.ifPresent(vet -> model.addAttribute("vet", vet));

        List<Event> eventList = eventRepository.findByPetId(1);
        model.addAttribute("events", eventList);

        return "petProfile";
    }

    @DeleteMapping("/deleteVet")
    public String deleteVet(@ModelAttribute Vet vet, Model model) {
        vetRepository.delete(vet);
        model.addAttribute("vet", vetRepository.findAll());
        return "petProfile";
    }

    @PostMapping("/addNewVet")
    public String submitNewVet(@ModelAttribute Vet vet, Model model) {
        model.addAttribute("vet", vet);
        vetRepository.saveAndFlush(vet);
        return "petProfile";
    }

    @GetMapping("/addNewVet")
    public String getAddNewVet(Model model) {
        model.addAttribute("vet", new Vet());
        return "addNewVet";
    }

    @PostMapping("/addNewEntry")
    public String submitNewEntry(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        eventRepository.saveAndFlush(event);
        return "petProfile";
    }

    @GetMapping("/addNewEntry")
    public String getAddNewEntry(Model model) {
        model.addAttribute("event", new Event());
        return "addNewEntry";
    }

    @DeleteMapping("/petProfile")
    public String deleteEntry(@ModelAttribute Event event, Model model) {
        eventRepository.delete(event);
        model.addAttribute("event", eventRepository.findAll());
        return "petProfile";
    }

}
