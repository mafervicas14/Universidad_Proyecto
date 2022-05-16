package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Persona;

public interface ProfesorDAO extends PersonaDAO
{
    public Persona actualizar(Persona profesorEncontrado, Persona profesor);
    /*
    public Iterable <Persona> findProfesoresByCarrera(String carrera);*/
}
