package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.entities.Persona;
import com.ibm.academia.universidad.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlumnoDAOImpl  extends GenericoDAOImpl<Persona,PersonaRepository> implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository) {
        super(repository);
    }
}
