package com.example.lab5.repository;

import com.example.lab5.entity.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.synth.Region;

@Repository
public interface RegionsRepository extends JpaRepository<Regions,Integer> {
}
