package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Persona;
import com.ibm.academia.universidad.repositories.AlumnoRepository;
import com.ibm.academia.universidad.repositories.PersonaRepository;
import com.ibm.academia.universidad.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO
{

    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository)
    {
        super(repository);
    }


    @Override
    public Persona actualizar(Persona profesorEncontrado, Persona profesor) {
        Persona profesorActualizado = null;
        profesorEncontrado.setNombre(profesor.getNombre());
        profesorEncontrado.setApellido(profesor.getApellido());
        profesorEncontrado.setDireccion(profesor.getDireccion());
        profesorActualizado = repository.save(profesorEncontrado);
        return profesorActualizado;
    }

    @Override
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }
}
