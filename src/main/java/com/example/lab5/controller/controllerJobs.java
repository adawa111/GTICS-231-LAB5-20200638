package com.example.lab5.controller;

import com.example.lab5.entity.Employees;
import com.example.lab5.repository.DepartamentsRepository;
import com.example.lab5.repository.EmployeesRepository;
import com.example.lab5.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Reportes")
public class controllerJobs {


    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartamentsRepository departamentsRepository;

    @GetMapping(value = {"", "/"})
    public String opcionesReportes() {
        return "Reportes y Dashboards";
    }


    @GetMapping(value = "/Salario")
    public String statsSalario(Model model) {

        model.addAttribute("listaPuestos", jobsRepository.salariosPorPuesto());
        return "ReportesSalarios";
    }

    @GetMapping(value = "/Tentativa")
    public String tentativaReportes() {
        return "Reportes Aumentos";
    }

}
