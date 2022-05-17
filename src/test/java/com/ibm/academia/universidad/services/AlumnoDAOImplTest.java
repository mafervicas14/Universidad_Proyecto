package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.repositories.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AlumnoDAOImplTest
{
    @MockBean
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AlumnoDAO alumnoDAO;

    @Test
    void buscarAlumnoPorNombreCarrera()
    {
        //When
        alumnoDAO.buscarAlumnoPorNombreCarrera(anyString());

        //Then
        verify(alumnoRepository).buscarAlumnoPorNombreCarrera(anyString());

    }
}
