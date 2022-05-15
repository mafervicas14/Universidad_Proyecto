package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.entities.Carrera;
import com.ibm.academia.universidad.entities.Persona;
import com.ibm.academia.universidad.entities.Profesor;
import com.ibm.academia.universidad.repositories.AlumnoRepository;
import com.ibm.academia.universidad.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AlumnoDAOImpl  extends PersonaDAOImpl implements AlumnoDAO
{

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository)
    {
        super(repository);
    }


    @Override
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre)
    {
        return ((AlumnoRepository)repository).buscarAlumnoPorNombreCarrera(nombre);
    }

    /*@Override
    public void Prueba(Carrera carrera) {
        Persona profesor = null;

        Optional<Persona> oProfesor = personaDao.buscarPorId(1);
        Optional<Persona> oProfesor2 = personaDao.buscarPorId(2);

        profesor = oProfesor.get();

        Set<Profesor> profesores = null;
        profesores.add((Profesor) profesor);

        Carrera carreraNueva = null ;
        carreraNueva.setProfesores(profesores);
    }*/
}
