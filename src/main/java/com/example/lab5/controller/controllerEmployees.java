package com.example.lab5.controller;


import com.example.lab5.entity.Employees;
import com.example.lab5.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Empleados")
public class controllerEmployees {


    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"", "/", "/listar"})
    public String listaEmpleados(Model model) {
        List<Employees> listaEmpleados = employeesRepository.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "Empleados";


    }
}