package com.example.lab5.controller;


import com.example.lab5.entity.Departaments;
import com.example.lab5.entity.Employees;
import com.example.lab5.entity.Jobs;
import com.example.lab5.repository.DepartamentsRepository;
import com.example.lab5.repository.EmpleadosFiltradosDto;
import com.example.lab5.repository.EmployeesRepository;
import com.example.lab5.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Empleados")
public class controllerEmployees {


    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartamentsRepository departamentsRepository;

    @GetMapping(value = {"", "/", "/listar"})
    public String listaEmpleados(Model model) {
        List<Employees> listaEmpleados = employeesRepository.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "Empleados";


    }
    @PostMapping(value = "/BuscarEmpleado")
    public String buscarEmpleado(Model model,
                                                 @RequestParam("filtro") String filtro) {

        String filtrolower = filtro.toLowerCase();
        System.out.println(filtrolower);
        model.addAttribute("listaEmpleados", employeesRepository.obtenerEmpleadosPorFiltro(filtrolower));
        return "EmpleadosFiltrados";
    }

    @GetMapping(value = "/Nuevo")
    public String nuevoEmpleado(Model model) {
        List<Jobs> listaPuesto = jobsRepository.findAll();
        List<Employees> listaEmpleados = employeesRepository.findAll();
        List<Departaments> listaDepartments = departamentsRepository.findAll();
        model.addAttribute("listaEmpleados", listaEmpleados);
        model.addAttribute("listaPuesto", listaPuesto);
        model.addAttribute("listaDepartments", listaDepartments);
        return "EmpleadoNuevo";
    }

    @GetMapping("/Editar")
    public String editarEmpleado(Model model, @RequestParam("id") int id) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            Employees e = optionalEmployees.get();
            model.addAttribute("empleado", e);
            List<Jobs> listaPuesto = jobsRepository.findAll();
            List<Employees> listaEmpleados = employeesRepository.findAll();
            List<Departaments> listaDepartments = departamentsRepository.findAll();
            model.addAttribute("listaEmpleados", listaEmpleados);
            model.addAttribute("listaPuesto", listaPuesto);
            model.addAttribute("listaDepartments", listaDepartments);
            return "EmpleadoEditar";
        } else {
            return "redirect:/Empleados";
        }
    }
    @PostMapping(value = "/GuardarEditar")
    public String guardarEditar(Model model, RedirectAttributes attr,
                                       @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
                                       @RequestParam("correo") String correo, @RequestParam("password") String password,
                                       @RequestParam("puesto") String puesto, @RequestParam("salario") Double salario,
                                       @RequestParam("jefe") int jefe, @RequestParam("departamento") String departamento, @RequestParam("id") int id) {
        employeesRepository.editarEmpleado(nombre,apellido,correo,password,puesto,salario,jefe,departamento,id);
        attr.addFlashAttribute("msg","Se ha editado al empleado " + nombre + apellido +" con éxito");
        return "redirect:/Empleados";
    }

    @PostMapping(value = "/Nuevo/Guardar")
    public String guardarNuevoEmpleado(Model model, RedirectAttributes attr,
                                       @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
                                       @RequestParam("correo") String correo, @RequestParam("password") String password,
                                       @RequestParam("puesto") String puesto, @RequestParam("salario") Double salario,
                                       @RequestParam("jefe") int jefe, @RequestParam("departamento") String departamento) {
        employeesRepository.nuevoEmpleado(nombre,apellido,correo,password,puesto,salario,jefe,departamento);
        attr.addFlashAttribute("msg","Empleado creado exitosamente");
        return "redirect:/Empleados";
    }

    @GetMapping("/Borrar")
    public String borrarEmpleado(Model model, RedirectAttributes attr, @RequestParam("id") int id) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            Employees e = optionalEmployees.get();
            employeesRepository.borrarEmpleado(id);
            attr.addFlashAttribute("msg","Empleado borrado exitosamente");
        }
        return "redirect:/Empleados";
    }

}