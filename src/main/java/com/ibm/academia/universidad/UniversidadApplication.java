package com.ibm.academia.universidad;

import com.ibm.academia.universidad.entities.Alumno;
import com.ibm.academia.universidad.entities.Direccion;
import com.ibm.academia.universidad.entities.Persona;
import com.ibm.academia.universidad.services.AlumnoDAO;
import com.ibm.academia.universidad.services.CarreraDAO;
import com.ibm.academia.universidad.services.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class UniversidadApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(UniversidadApplication.class, args);
	}

	/*
	//Si quisiera probar desde main
	@Bean
	public CommandLineRunner runner(){
		return args -> {

		};
	}*/

}
