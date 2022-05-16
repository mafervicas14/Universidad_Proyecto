package com.ibm.academia.universidad.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.universidad.models.entities.Carrera;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AlumnoDTO extends PersonaDTO
{
    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name="carrera_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "alumnos"})
    private Carrera carrera;
}
