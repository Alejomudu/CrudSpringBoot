package com.example.demo.service;

import com.example.demo.model.entity.DeveloperaEntity;
import org.springframework.http.ResponseEntity;

public interface IDeveloperaService {

    ResponseEntity getListarDevelopers();

    ResponseEntity saveInformationDevelopera(DeveloperaEntity developeraEntity);

    ResponseEntity deleteDeveloper(DeveloperaEntity developeraEntity);


}
