package com.example.BackendLojaVirtual.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")

public class Hello {

    @GetMapping("/")
    public String hello(){
        return "Deu certo?";
    }

}
