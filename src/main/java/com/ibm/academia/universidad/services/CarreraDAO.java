package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.entities.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera>
{
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
	public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
	public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios); 
}
