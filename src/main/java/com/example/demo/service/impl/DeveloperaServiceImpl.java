package com.example.demo.service.impl;

import com.example.demo.model.entity.DeveloperaEntity;
import com.example.demo.model.repository.DeveloperaRepository;
import com.example.demo.service.IDeveloperaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public ResponseEntity saveInformationDevelopera(DeveloperaEntity developeraEntity) {

        String mensaje;

        DeveloperaEntity developerdb = developeraRepository.findAllBydocDev(developeraEntity.getDocDev());
        if(Objects.isNull(developerdb)){
            if(developeraEntity.getPorcHabilidad()>0 && developeraEntity.getPorcHabilidad()<=100){
                developeraEntity.setPorcHabilidad(developeraEntity.getPorcHabilidad());
                developeraRepository.save(developeraEntity);
            }else{
                mensaje="El porcentaje no es correcto";
                return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);

            }
            mensaje="Desarrollador guardado exitosamente";
        }else{
            mensaje="Desarrollador ya existe";
        }



        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @Override
    public ResponseEntity deleteDeveloper(DeveloperaEntity developeraEntity) {
        String mensaje;

        DeveloperaEntity developerdb = developeraRepository.findAllBydocDev(String.valueOf(developeraEntity.getDocDev()));

        if (developerdb != null) {
            developeraRepository.delete(developerdb);
            mensaje = "El desarrollador ha sido eliminado";
        } else {
            mensaje = "El desarrollador no existe";
        }

        return ResponseEntity.status(HttpStatus.OK).body(mensaje);
    }

}


