package com.example.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class controllerBase {
    @RequestMapping("/**")
    public String handleDefault() {
        return "Recursos Humanos - TravelTrip"; // Nombre de la vista predeterminada
    }

}