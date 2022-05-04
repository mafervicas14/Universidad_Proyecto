package com.ibm.academia.universidad.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name="carreras", schema = "universidad")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre", unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(name="cantidad_materias")
    private Integer cantidadMaterias;

    @Column(name="cantidad_anios")
    private Integer cantidadAnios;

    @Column(name="fecha_alta")
    private Date fechaAlta;

    @Column(name="fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    private Set<Profesor> profesores;

    public Carrera(Integer id, String nombre, Integer cantidad, Integer cantidadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrera)) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) && nombre.equals(carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    //Métodos
    @PrePersist
    private void antesPersistir(){
        this.fechaAlta = new Date();
    }
    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion = new Date();
    }
}