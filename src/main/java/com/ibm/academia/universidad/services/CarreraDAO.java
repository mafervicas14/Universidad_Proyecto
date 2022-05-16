package com.ibm.academia.universidad.services;

import com.ibm.academia.universidad.models.entities.Carrera;

public interface CarreraDAO extends GenericoDAO<Carrera>
{
	public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
	public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
	public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
	public Carrera actualizar (Carrera carreraEncontrada, Carrera carrera);
}
