package com.example.crdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revision")
public class RevisionController {

    @GetMapping("/apiversion")
    public String apiversion(){
        return "this is version v1";
    }
}
