package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="developer")
public class DeveloperaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido;

    @Column(name="tipo_documento")
    private String docDev;

    @Column(name = "lenguaje_prog")
    private String lenguajeProgramcion;

    @Column(name = "porcentaje_habilidad")
    private int porcHabilidad;

}
