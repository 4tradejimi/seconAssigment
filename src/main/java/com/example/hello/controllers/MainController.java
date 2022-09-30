package com.example.hello.controllers;

import com.example.hello.model.MessageHello;
import com.example.hello.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    MessageRepo messageRepo;

    @RequestMapping(value = "/")
    public String testa(){
        return "cao";
    }


    @GetMapping("/hello/{language}")
    String gethay(Model model, @PathVariable(value = "language") String language){
        MessageHello k = null;
        for(MessageHello m : messageRepo.findAll())
            if(m.getLanguage().equalsIgnoreCase(language)){
                k = m;
            }
        if(k != null){
            model.addAttribute("message", k.getTextMessage());
        }else{
            model.addAttribute("message", "nema tog jezika");
        }

        return "hey";
    }

    @RequestMapping("/secure/hello")
    public String slogin(){
        return "login";
    }

    @RequestMapping (value= "/admin" , method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("message", new MessageHello());
        return "admin-form";
    }

    @RequestMapping (value= "/admin", method = RequestMethod.POST)
    public String doForm(@ModelAttribute("message") MessageHello message){
        messageRepo.save(message);
        return "redirect:/api/";
    }




}
