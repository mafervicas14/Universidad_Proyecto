package com.ibm.academia.universidad.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO
{
    private Integer id;

    @Column(name="nombre", unique = true, nullable = false, length = 80)
    private String nombre;

    @Column(name="cantidad_materias")
    private Integer cantidadMaterias;

    @Column(name="cantidad_anios")
    private Integer cantidadAnios;
}
