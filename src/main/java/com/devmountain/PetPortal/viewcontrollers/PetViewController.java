package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Event;
import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.Vet;
import com.devmountain.PetPortal.repositories.EventRepository;
import com.devmountain.PetPortal.repositories.PetRepository;
import com.devmountain.PetPortal.repositories.UserRepository;
import com.devmountain.PetPortal.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
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
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/petProfile/{pet_id}")
    public String getPetProfile(Model model, @PathVariable Integer pet_id) {
        Optional<Pet> petOptional = petRepository.findById(pet_id);
        petOptional.ifPresent(pet -> model.addAttribute("pet", pet));

        Optional<Vet> vetOptional = vetRepository.findVetByPetId(pet_id);
        vetOptional.ifPresent(vet -> model.addAttribute("vet", vet));

        List<Event> eventList = eventRepository.findEventsByPetId(pet_id);
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
    public String submitNewEntry(@ModelAttribute Event event, Model model, @RequestParam Integer petId) {
        Optional<Pet> eventPetOptional = petRepository.findById(petId);
        eventPetOptional.ifPresent(pet -> {
            event.setPet(pet);
            model.addAttribute("pet", pet);
            model.addAttribute("vet", pet.getVet());
        });

        if(eventPetOptional.isEmpty()) {
            model.addAttribute("pet", new Pet());
        }

        eventRepository.saveAndFlush(event);
        model.addAttribute("events", eventRepository.findEventsByPetId(petId));
        return "petProfile";
    }

    @GetMapping("/addNewEntry")
    public String getAddNewEntry(Model model, @RequestParam Integer petId) {
        model.addAttribute("petId", petId);
        model.addAttribute("event", new Event());
        return "addNewEntry";
    }

    @DeleteMapping("/deleteEntry/{entryId}")
    public String deleteEntry(Model model, @PathVariable Integer entryId) {
        Optional<Event> eventOptional = eventRepository.findById(entryId);
        eventOptional.ifPresent(event -> {
            eventRepository.deleteById(entryId);

            model.addAttribute("pet", event.getPet());
            Integer petId = event.getPet().getPet_id();
            Optional<Vet> vetOptional = vetRepository.findVetByPetId(petId);
            vetOptional.ifPresent(vet -> { model.addAttribute("vet", vet); });
            model.addAttribute("events", eventRepository.findEventsByPetId(petId));
            });

        return "petProfile";
    }

}
