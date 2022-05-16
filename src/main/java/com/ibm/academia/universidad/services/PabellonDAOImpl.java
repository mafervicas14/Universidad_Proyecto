package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Pabellon;
import com.ibm.academia.universidad.repositories.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl <Pabellon, PabellonRepository> implements PabellonDAO
{
    @Autowired
    public PabellonDAOImpl(PabellonRepository repository)
    {
        super(repository);
    }
}
