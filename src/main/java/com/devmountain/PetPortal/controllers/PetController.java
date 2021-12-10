package com.devmountain.PetPortal.controllers;

import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.repositories.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets/")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<Pet> pet() {
        return petRepository.findAll();
    }

    @GetMapping("{pet_id}")
    public Pet get(@PathVariable Integer pet_id) {
        return petRepository.getById(pet_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet create(@RequestBody final Pet pet) {
        return petRepository.saveAndFlush(pet);
    }

    @RequestMapping(value = "{pet_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer pet_id) {
        petRepository.deleteById(pet_id);
    }

    @RequestMapping(value = "{pet_id}", method = RequestMethod.PUT)
    public Pet update(@PathVariable Integer pet_id, @RequestBody Pet pet) {
        Pet existingPet = petRepository.getById(pet_id);
        BeanUtils.copyProperties(pet, existingPet, "pet_id");
        return petRepository.saveAndFlush(existingPet);
    }
}