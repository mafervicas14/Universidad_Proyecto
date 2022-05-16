package com.ibm.academia.universidad.mapper;

import com.ibm.academia.universidad.models.dto.PersonaDTO;
import com.ibm.academia.universidad.models.entities.Persona;

public class PersonaMapper
{
    public static PersonaDTO mapPersona(Persona persona)
    {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setDni(persona.getDni());
        return personaDTO;
    }
}
