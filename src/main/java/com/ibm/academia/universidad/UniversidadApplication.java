package com.ibm.academia.universidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
