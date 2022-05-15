package com.ibm.academia.universidad;

import com.ibm.academia.universidad.entities.Carrera;
import com.ibm.academia.universidad.entities.Persona;
import com.ibm.academia.universidad.services.AlumnoDAO;
import com.ibm.academia.universidad.services.CarreraDAO;
import com.ibm.academia.universidad.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Comandos implements CommandLineRunner {

   /* private CarreraDAO carreraDAO;

    //Forma Correcta
    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDao;

    @Autowired
    private AlumnoDAO alumnoDao;*/


    @Override
    public void run(String... args) throws Exception {

        /*
        // Insertar carrera
			Carrera finanzas = new Carrera(null, "Ingenieria en finanzas", 20, 3);
			Carrera carreraGuardada = carreraDAO.guardar(finanzas);
			System.out.println(carreraGuardada.toString());*/


			/*
			//Insertar alumnos
			Direccion direccion = new Direccion("Bosques de Viena", "10", "54780", "2", "4", "Bosques del Lago");
			Persona alumno = new Alumno(null, "Emilio", "Huerta", "65435", direccion);

			Persona personaGuardada = alumnoDAO.guardar(alumno);
			System.out.println("***********");
			System.out.println(personaGuardada.toString());

			Direccion direccion = new Direccion("Bosques de Viena", "10", "54780", "2", "4", "Bosques del Lago");
			Persona alumno = new Alumno(null, "Mafer", "Villegas", "65436", direccion);

			Persona personaGuardada = alumnoDao.guardar(alumno);
			System.out.println("***********");
			System.out.println(personaGuardada.toString());*/


			/*
			//Buscar todos los alumnos
			List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();
			alumnos.forEach(System.out::println);*/

			/*
			//Buscar por id de carrera
			Optional<Carrera> oCarrera = carreraDAO.buscarPorId(1);
			System.out.println(oCarrera.toString());*/


			/*
			//Modificar Carrera
			Carrera carrera = null;
			Optional<Carrera> oCarrera= carreraDAO.buscarPorId(1);
			if(oCarrera.isPresent()){
				carrera = oCarrera.get();
				System.out.println(carrera.toString());
			}
			else {
				System.out.println("Carrera no encontrada");
			}
			carrera.setCantidadMaterias(50);
			carreraDAO.guardar(carrera);*/


			/*
			//Eliminar registro con Lambda
			carreraDAO.eliminarPorId(2);
			System.out.println(carreraDAO.buscarPorId(2).orElse(new Carrera()).toString());*/


			/*
			// Insertar Carreras
			Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
			Carrera  ingIdustrial= new Carrera(null, "Ingenieria Industrial", 55, 5);
			Carrera  ingAlimentos= new Carrera(null, "Ingenieria en Alimentos", 53, 5);
			Carrera  ingElectronica= new Carrera(null, "Ingenieria Electrónica", 45, 5);
			Carrera  licSistemas= new Carrera(null, "Licenciatura en Sistemas", 40, 4);
			Carrera  licTurismo= new Carrera(null, "Licenciatura en Turismo", 42, 4);
			Carrera  licNutricion= new Carrera(null, "Licenciatura en Nutrición", 25,3 );
			Carrera  licRecursos= new Carrera(null, "Licenciatura en Recursos Humanos",33 ,3 );

			carreraDAO.guardar(ingSistemas);
			carreraDAO.guardar(ingAlimentos);
			carreraDAO.guardar(ingElectronica);
			carreraDAO.guardar(licSistemas);
			carreraDAO.guardar(licTurismo);
			carreraDAO.guardar(licNutricion);
			carreraDAO.guardar(licRecursos);
			carreraDAO.guardar(ingIdustrial);*/

            /*
            //Buscar por ID
            Optional<Carrera> IngSistemas = carreraDAO.buscarPorId(3);
			Iterable<Persona> alumnos = personaDao.buscarTodos();
			alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(IngSistemas.get()));
			alumnos.forEach(alumno -> personaDao.guardar(alumno));*/


            /*
            //Buscar por Nombre Carrera
            Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(2);
            Iterable<Persona> alumnosCarrera = ((AlumnoDAO) personaDao).buscarAlumnoPorNombreCarrera((ingSistemas.get().getNombre()));
            alumnosCarrera.forEach(System.out::println);*/


        /*
        //Por Query
        Optional<Carrera> ingSistemas = carreraDAO.buscarPorId(2);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO) personaDao).buscarAlumnoPorNombreCarrera((ingSistemas.get().getNombre()));
        alumnosCarrera.forEach(System.out::println);*/


        /*
        //Por Método
        List<Carrera> carreras = (List<Carrera>)carreraDAO.findCarrerasByNombreContains("Sistemas");
        carreras.forEach(System.out::println)

        List<Carrera> carrerasPorAnio = (List<Carrera>)carreraDAO.findCarrerasByCantidadAniosAfter(3);
			carrerasPorAnio.forEach(System.out::println);;*/


       /*
        //Por consulta nativa
        Optional<Persona> persona = personaDao.buscarPorId(3);
        System.out.println(persona.toString());*/


       /*
       //Buscar Dni
        Optional<Persona> alumno = alumnoDao.buscarPorId(1);
        Optional<Persona> personaDni = personaDao.buscarPorDni(alumno.get().getDni());
        System.out.println("DNI: "+ personaDni.toString());*/



    }
}
