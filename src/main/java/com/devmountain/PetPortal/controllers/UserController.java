package com.devmountain.PetPortal.controllers;

import com.devmountain.PetPortal.models.User;
import com.devmountain.PetPortal.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> user() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{user_id}")
    public User get(@PathVariable Integer user_id) {
        return userRepository.getById(user_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user) {
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{user_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer user_id) {
        userRepository.deleteById(user_id);
    }

    //Patch Update????
    @RequestMapping(value = "{user_id}", method = RequestMethod.PUT)
    public User update(@PathVariable Integer user_id, @RequestBody User user) {
        User existingUser = userRepository.getById(user_id);
        BeanUtils.copyProperties(user, existingUser, "user_id");
        return userRepository.saveAndFlush(existingUser);
    }
}
