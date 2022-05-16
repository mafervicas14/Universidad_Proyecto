package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Aula;
import com.ibm.academia.universidad.repositories.AulaRepository;
import com.ibm.academia.universidad.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO
{
    @Autowired
    public AulaDAOImpl(AulaRepository repository) {
        super(repository);
    }
}
