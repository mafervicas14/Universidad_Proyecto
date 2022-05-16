package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>
{
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
    public Optional<Persona> buscarPorDni(String dni);
    public Iterable<Persona> buscarPersonaPorApellido(String apellido);
}
