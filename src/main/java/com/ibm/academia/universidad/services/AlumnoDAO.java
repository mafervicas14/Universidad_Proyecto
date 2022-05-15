package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.entities.Carrera;
import com.ibm.academia.universidad.entities.Persona;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnoDAO extends PersonaDAO
{

    public Iterable <Persona> buscarAlumnoPorNombreCarrera(String nombre);
    //public void Prueba(Carrera carrera);

}
