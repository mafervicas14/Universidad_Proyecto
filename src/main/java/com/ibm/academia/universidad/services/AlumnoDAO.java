package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.models.entities.Persona;

public interface AlumnoDAO extends PersonaDAO
{

    public Iterable <Persona> buscarAlumnoPorNombreCarrera(String nombre);
    //public void Prueba(Carrera carrera);
    public Persona actualizar(Persona alumnoEncontrado, Persona alumno);
    public Persona asociarCarreraAlumno(Persona alumno, Carrera carrera);

}
