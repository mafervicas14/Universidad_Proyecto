package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Alumno;
import com.ibm.academia.universidad.models.entities.Carrera;
import com.ibm.academia.universidad.models.entities.Persona;
import com.ibm.academia.universidad.repositories.AlumnoRepository;
import com.ibm.academia.universidad.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoDAOImpl  extends PersonaDAOImpl implements AlumnoDAO
{

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos") PersonaRepository repository)
    {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre)
    {
        return ((AlumnoRepository)repository).buscarAlumnoPorNombreCarrera(nombre);
    }

    @Override
    @Transactional
    public Persona actualizar(Persona alumnoEncontrado, Persona alumno) {
        Persona alumnoActualizado = null;
        alumnoEncontrado.setNombre(alumno.getNombre());
        alumnoEncontrado.setApellido(alumno.getApellido());
        alumnoEncontrado.setDireccion(alumno.getDireccion());
        alumnoActualizado = repository.save(alumnoEncontrado);
        return alumnoActualizado;
    }

    @Override
    @Transactional
    public Persona asociarCarreraAlumno(Persona alumno, Carrera carrera) {
        ((Alumno)alumno).setCarrera(carrera);
        return repository.save(alumno);
    }

    /*@Override
    public void Prueba(Carrera carrera) {
        Persona profesor = null;

        Optional<Persona> oProfesor = personaDao.buscarPorId(1);
        Optional<Persona> oProfesor2 = personaDao.buscarPorId(2);

        profesor = oProfesor.get();

        Set<Profesor> profesores = null;
        profesores.add((Profesor) profesor);

        Carrera carreraNueva = null ;
        carreraNueva.setProfesores(profesores);
    }*/
}
