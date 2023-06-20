package com.example.demo.controller;

import com.example.demo.model.entity.DeveloperaEntity;
import com.example.demo.service.IDeveloperaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desarrolladores")
public class DeveloperaController {

    private final IDeveloperaService iDeveloperaService;

    public DeveloperaController(IDeveloperaService iDeveloperaService) {
        this.iDeveloperaService = iDeveloperaService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return iDeveloperaService.getListarDevelopers();
    }

    @PostMapping
    public ResponseEntity guardarInfomacion(@RequestBody DeveloperaEntity developeraEntity){

        return iDeveloperaService.saveInformationDevelopera(developeraEntity);
    }

    @DeleteMapping
    public ResponseEntity eliminarDesarrollador(@RequestBody DeveloperaEntity developeraEntity){
        return iDeveloperaService.deleteDeveloper(developeraEntity);
    }
}
