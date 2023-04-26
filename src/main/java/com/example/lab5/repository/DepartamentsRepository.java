package com.example.lab5.repository;


import com.example.lab5.entity.Departaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentsRepository extends JpaRepository<Departaments,Integer> {
}
