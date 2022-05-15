package com.ibm.academia.universidad.controllers;


import com.ibm.academia.universidad.entities.Carrera;
import com.ibm.academia.universidad.exceptions.BadRequestException;
import com.ibm.academia.universidad.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrera")
public class CarreraController
{

    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping("/lista/carreras")
    public List<Carrera> buscarTodas()
    {
        List<Carrera> carreras = (List<Carrera>) carreraDAO.buscarTodos();
        if(carreras.isEmpty())
            throw  new BadRequestException("No existen carreras");
        return carreras;
    }

    @GetMapping("/id/{carreraId}")
    public Carrera buscarCarreraPorId(@PathVariable Integer carreraId)
    {
        Optional<Carrera> oCarrera = carreraDAO.buscarPorId(carreraId);
        if(!oCarrera.isPresent())
            throw new BadRequestException(String.format("La carrera con ID: %d no existe", carreraId));

        return  oCarrera.get();
    }
}
