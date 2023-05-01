package com.example.lab5.repository;

import com.example.lab5.entity.Departaments;
import com.example.lab5.entity.Employees;
import com.example.lab5.entity.Jobs;

public interface EmpleadosFiltradosDto {
   int getId();

   String getNombre();

   String getApellido();

   String getPuesto();

   String getDepartamento();

   String getCiudad();

}
