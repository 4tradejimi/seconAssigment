package com.example.hello.controllers;

import com.example.hello.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestCont {
    @Autowired
    MessageRepo messageRepo;

    @GetMapping(path = "/")
    public String admin1(){
        return (messageRepo.findAll()).toString();
    }
}
