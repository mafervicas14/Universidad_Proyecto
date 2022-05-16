package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.models.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository
{
    //@Query("select a from Alumno a where a.carrera.nombre = ?1")
    //@Query("select a from Profesor a join fetch a.carrera c where c.carrera = ?1")
   // public Iterable<Persona> findProfesoresByCarrera (String carrera);
}
