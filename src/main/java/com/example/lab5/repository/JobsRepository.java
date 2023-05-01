package com.example.lab5.repository;

import com.example.lab5.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface JobsRepository extends JpaRepository<Jobs,Integer> {



    @Query(value = "select jobs.job_title as puesto, max(employees.salary) as maximo, min(employees.salary) as minimo, sum(employees.salary) as total, round(avg(employees.salary),2) as promedio\n" +
            "from jobs\n" +
            "inner join employees on jobs.job_id=employees.job_id\n" +
            "group by jobs.job_title",nativeQuery = true)
    List<SalariosPorPuestosDTO> salariosPorPuesto();
}
