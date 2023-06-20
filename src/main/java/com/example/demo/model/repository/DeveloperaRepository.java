package com.example.demo.model.repository;

import com.example.demo.model.entity.DeveloperaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperaRepository extends JpaRepository<DeveloperaEntity, Integer> {

    DeveloperaEntity findAllBydocDev(String docDev);


}
