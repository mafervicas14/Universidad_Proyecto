package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.entities.Persona;
import com.ibm.academia.universidad.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO

{
    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    public Optional<Persona> buscarPorDni(String dni) {
        return repository.buscarPorDni(dni);
    }

    @Override
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return repository.buscarPersonaPorApellido(apellido);
    }
}

