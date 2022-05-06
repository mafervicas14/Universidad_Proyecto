package com.ibm.academia.universidad;

import com.ibm.academia.universidad.entities.Carrera;
import com.ibm.academia.universidad.entities.Persona;
import com.ibm.academia.universidad.services.AlumnoDAO;
import com.ibm.academia.universidad.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class UniversidadApplication {

	@Autowired
	private CarreraDAO carreraDAO;

	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(){
		return args -> {

			/* Insertar carrera
			Carrera finanzas = new Carrera(null, "Ingenieria en finanzas", 20, 3);
			Carrera carreraGuardada = carreraDAO.guardar(finanzas);
			System.out.println(carreraGuardada.toString());*/

			/* Insertar alumno
			Direccion direccion = new Direccion("Bosques de Viena", "10", "54780", "2", "4", "Bosques del Lago");
			Persona alumno = new Alumno(null, "Emilio", "Huerta", "65435", direccion);

			Persona personaGuardada = alumnoDAO.guardar(alumno);
			System.out.println("***********");
			System.out.println(personaGuardada.toString());*/

			/*Buscar todos los alumnos
			List<Persona> alumnos = (List<Persona>) alumnoDAO.buscarTodos();
			alumnos.forEach(System.out::println);*/

			/*Buscar por id de carrera
			Optional<Carrera> oCarrera = carreraDAO.buscarPorId(1);
			System.out.println(oCarrera.toString());*/

			/*Modificar Carrera
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

			/*Eliminar registro con Lambda
			carreraDAO.eliminarPorId(2);
			System.out.println(carreraDAO.buscarPorId(2).orElse(new Carrera()).toString());
*/
		};
	}

}
