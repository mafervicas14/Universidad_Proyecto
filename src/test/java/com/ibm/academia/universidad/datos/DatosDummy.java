package com.ibm.academia.universidad.datos;

import com.ibm.academia.universidad.enums.TipoEmpleado;
import com.ibm.academia.universidad.models.entities.*;

import java.math.BigDecimal;

public class DatosDummy
{
    public static Carrera carrera01()
    {
        return new Carrera(null, "Ingenieria en Sistemas", 50, 5);
    }

    public static Carrera carrera02()
    {
        return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
    }

    public static Carrera carrera03()
    {
        return new Carrera(null, "Ingenieria Industrial", 60, 5);
    }

    //Datos Persona
    public static Persona empleado01()
    {
        return new Empleado(null, "Lautaro", "Lopez", "25174030", new Direccion(), new BigDecimal("46750.70"), TipoEmpleado.ADMINISTRATIVO);
    }

    public static Persona empleado02()
    {
        return new Empleado(null, "Lenadro", "Lopez", "25174036", new Direccion(), new BigDecimal("46750.70"), TipoEmpleado.MANTENIMIENTO);
    }

    public static Persona profesor01()
    {
        return new Profesor(null, "Martin", "Lugone", "3368765", new Direccion(), new BigDecimal("600000.00"));
    }

    public static Persona alumno01()
    {
        return new Alumno(null, "Jhon", "Benitez", "45766564", new Direccion());
    }

    public static Persona alumno02()
    {
        return new Alumno(null, "Andres", "Benitez", "45766560", new Direccion());
    }

    public static Persona alumno03()
    {
        return new Alumno(null, "Joaquín", "Leon", "42366564", new Direccion());
    }

}
