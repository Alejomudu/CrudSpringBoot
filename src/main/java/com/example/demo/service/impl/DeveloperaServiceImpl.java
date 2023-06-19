package com.example.demo.service.impl;

import com.example.demo.model.repository.DeveloperaRepository;
import com.example.demo.service.IDeveloperaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeveloperaServiceImpl implements IDeveloperaService {

    private final DeveloperaRepository developeraRepository;

    public DeveloperaServiceImpl(DeveloperaRepository developeraRepository){
        this.developeraRepository = developeraRepository;
    }

    @Override
    public ResponseEntity getListarDevelopers() {
        var listadevelopers = developeraRepository.findAll();
        return ResponseEntity.ok(listadevelopers);
    }
}
