package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.models.Pet;
import com.devmountain.PetPortal.models.User;
import com.devmountain.PetPortal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginViewController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin() { return "login"; }

    @PostMapping("/loginVerif")
    @ResponseBody
    public String loginVerif(@RequestParam(name = "email") String userEmail, @RequestParam(name = "password") String userPass) {
        User user = userRepository.findByEmail(userEmail);
        System.out.println(userPass);
        System.out.println(user.getPassword());
        if(user.getPassword().equals(userPass)) {
            return "userProfile";
        } else {
            return "login";
        }
    }

    @PostMapping("/register")
    public String submitNewUser(@ModelAttribute User user, Model model) {
    model.addAttribute("user", user);
    userRepository.saveAndFlush(user);
    return "login";
    }

    @GetMapping("/register")
    public String getAddNewUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}




