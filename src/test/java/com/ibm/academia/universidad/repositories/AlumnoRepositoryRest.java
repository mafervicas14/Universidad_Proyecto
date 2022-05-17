package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.datos.DatosDummy;
import com.ibm.academia.universidad.models.entities.Alumno;
import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.models.entities.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
public class AlumnoRepositoryRest
{
    @Autowired
    @Qualifier("repositorioAlumnos")
    private  PersonaRepository alumnoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Test
    void buscarAlumnoPorNombreCarrera(){

        Iterable<Persona> personas = alumnoRepository.saveAll(
            Arrays.asList(
                    DatosDummy.alumno01(),
                    DatosDummy.alumno02(),
                    DatosDummy.alumno03())
                    );
        Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
        alumnoRepository.saveAll(personas);

        String carreraNombre = "Ingenieria en Sistemas";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(carreraNombre);

        assertThat(expected.size()== 3).isTrue();


    }
}


