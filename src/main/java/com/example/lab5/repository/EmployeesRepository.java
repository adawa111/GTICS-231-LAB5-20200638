package com.example.lab5.repository;

import com.example.lab5.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {


    @Query(value = "select employees.employee_id as id, employees.first_name as nombre, employees.last_name as apellido, jobs.job_title as puesto, departments.department_name as departamento, locations.city as ciudad\n" +
            "from employees\n" +
            "inner join jobs on employees.job_id = jobs.job_id\n" +
            "inner join departments on employees.department_id = departments.department_id\n" +
            "inner join locations on departments.location_id = locations.location_id\n" +
            "where LOWER(employees.first_name) like %?1% or LOWER(employees.last_name) like %?1% or LOWER(jobs.job_title) like %?1% or LOWER(locations.city) like %?1%", nativeQuery = true)
    List<EmpleadosFiltradosDto> obtenerEmpleadosPorFiltro(String filtro);


    @Transactional
    @Modifying
    @Query(value = "insert into employees (first_name,last_name,email,password,job_id,salary,manager_id,department_id) values(?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
    void nuevoEmpleado(@Param("nombre") String nombre, @Param("apellido") String apellido,
                       @Param("correo") String correo,@Param("password") String password,
                       @Param("puesto") String puesto, @Param("salario") Double salario,
                       @Param("jefe") int jefe, @Param("departamento") String departamento);

    @Transactional
    @Modifying
    @Query(value = "update  employees set first_name =?1,last_name =?2,email =?3,password=?4,job_id=?5,salary=?6,manager_id=?7,department_id=?8 where employee_id = ?9",nativeQuery = true)
    void editarEmpleado(@Param("nombre") String nombre, @Param("apellido") String apellido,
                       @Param("correo") String correo,@Param("password") String password,
                       @Param("puesto") String puesto, @Param("salario") Double salario,
                       @Param("jefe") int jefe, @Param("departamento") String departamento,@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "delete from employees where employee_id =?1",nativeQuery = true)
    void borrarEmpleado(@Param("id") int id);


}
