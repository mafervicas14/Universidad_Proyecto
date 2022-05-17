package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.datos.DatosDummy;
import com.ibm.academia.universidad.models.entities.Empleado;
import com.ibm.academia.universidad.models.entities.Persona;
import com.ibm.academia.universidad.models.entities.Profesor;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJdbcTest
public class PersonaRepositoryTest
{

    @Autowired
    @Qualifier("repositorioAlumnos")
    private  PersonaRepository alumnoRepository;

    @Autowired
    @Qualifier("repositorioEmpleados")
    private PersonaRepository empleadoRepository;

    @Autowired
    @Qualifier("profesorRepository")
    private PersonaRepository profesorRepository;

    @Test
    @DisplayName("Test: Buscar por Nombre y Apellido")
    void buscarPorNombreYApellido()
    {
        //Given
        Persona personaEmpleado = empleadoRepository.save(DatosDummy.empleado01());

        //When
        Optional<Persona> expected = empleadoRepository.buscarPorNombreYApellido(DatosDummy.empleado01().getNombre(), DatosDummy.empleado01().getApellido());

        //Then
        assertThat(expected.get()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(personaEmpleado);

    }


    @Test
    @DisplayName("Test: Buscar por DNI")
    void buscarPorDni()
    {
        //Given
        Persona personaProfesor = profesorRepository.save(DatosDummy.profesor01());

        //When
        Optional<Persona> expected = profesorRepository.buscarPorDni(DatosDummy.profesor01().getDni());

        //Then
        assertThat(expected.get()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(personaProfesor);
        assertThat(expected.get().getDni()).isEqualTo(personaProfesor.getDni());

    }


    @Test
    @DisplayName("Test: Buscar por Apellido")
    void buscarPersonaPorApellido()
    {
        //Given
        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(DatosDummy.alumno01());
        listaPersonas.add(DatosDummy.alumno02());
        listaPersonas.add(DatosDummy.alumno03());

        Iterable <Persona> personas = alumnoRepository.saveAll(listaPersonas);

        //When
        String apellido = "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepository.buscarPersonaPorApellido(apellido);

        //Then
        assertThat(expected.size() == 2).isTrue();
    }

}
