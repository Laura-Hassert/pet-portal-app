package com.devmountain.PetPortal.viewcontrollers;

import com.devmountain.PetPortal.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @RequestMapping("/")
    @ResponseBody
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", appVersion);
        return map;
    }

    @GetMapping("/index")
    public String getIndex() {
        return "index";
    }

    @Autowired
    private PetRepository petRepository;

//    @GetMapping("/petProfile")
//    public String getPetProfile(Model model) {
//        model.addAttribute("pet", petRepository.findById(1));
//        return "petProfile";
//    }

    @GetMapping("/addNewVet")
    public String getAddNewVet() { return "addNewVet"; }

    @GetMapping("/addNewEntry")
    public String getAddNewEntry() { return "addNewEntry"; }

}
