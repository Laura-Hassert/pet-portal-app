package com.devmountain.PetPortal.controllers;

import com.devmountain.PetPortal.models.Vet;
import com.devmountain.PetPortal.repositories.VetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vets/")
public class VetController {

    @Autowired
    private VetRepository vetRepository;

    @GetMapping
    public List<Vet> vet() {
        return vetRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{vet_id}")
    public Vet get(@PathVariable Integer vet_id) {
        return vetRepository.getById(vet_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vet create(@RequestBody final Vet vet) {
        return vetRepository.saveAndFlush(vet);
    }

    @RequestMapping(value = "{vet_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer vet_id) {
        vetRepository.deleteById(vet_id);
    }

    @RequestMapping(value = "{vet_id}", method = RequestMethod.PUT)
    public Vet update(@PathVariable Integer vet_id, @RequestBody Vet vet) {
        Vet existingVet = vetRepository.getById(vet_id);
        BeanUtils.copyProperties(vet, existingVet, "vet_id");
        return vetRepository.saveAndFlush(existingVet);
    }
}