package com.ibm.academia.universidad.repositories;

import com.ibm.academia.universidad.models.entities.Carrera;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import com.ibm.academia.universidad.datos.DatosDummy;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJdbcTest
public class CarreraRepositoryTest
{
    @Autowired
    private CarreraRepository carreraRepository;

    @Test
    @DisplayName("Test: Buscar carreras por nombre SI case sensitive")
    void findCarrerasByNombreContains()
    {
        //Given
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());

        //When
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("Sistemas");

        //Then
        assertThat(((List<Carrera>)expected).size() == 2).isTrue();

    }

    @Test
    @DisplayName("Test: Buscar carreras por nombre NO case sensitive")
    void findCarrerasByNombreContainsIgnoreCase()
    {
        //Given
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());

        //When
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");

        //Then
        assertThat(expected.size() == 2).isTrue();

    }


    @Test
   void findCarrerasByCantidadAniosAfter()
    {
        //Given
        carreraRepository.save(DatosDummy.carrera01());
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03());

        //When
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);

        //Then
        assertThat(expected.size() == 2).isTrue();

    }

}
