package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.datos.DatosDummy;
import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.repositories.CarreraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CarreraDAOImplTest
{
    CarreraDAO carreraDAO;
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp()
    {
        carreraRepository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepository);
    }

    @Test
    @DisplayName("Test: Buscar carrera por nombre")
    void findCarrerasByNombreContains()
    {
        //Given
        String nombre = "Ingenieria";
        when(carreraRepository.findCarrerasByNombreContains(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByNombreContains(nombre);
    }

    @Test
    @DisplayName("Test: Buscar carrera por nombre")
    void findCarrerasByNombreContainsIgnoreCase()
    {
        //Given
        String nombre = "ingenieria";
        when(carreraRepository.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

        //When
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //Then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByNombreContainsIgnoreCase(nombre);

    }

    @Test
    @DisplayName("Test: Buscar por cantidad despues de N años")
    void findCarrerasByCantidadAniosAfter()
    {
        int cantidad = 4;
        when(carreraRepository.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(), DatosDummy.carrera03()));

        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //Then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01());
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03());

        verify(carreraRepository).findCarrerasByCantidadAniosAfter(cantidad);


    }

}
