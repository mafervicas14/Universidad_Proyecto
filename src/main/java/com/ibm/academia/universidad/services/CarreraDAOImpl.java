package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.entities.Carrera;
import com.ibm.academia.universidad.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDAO{

    @Autowired
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }
}
