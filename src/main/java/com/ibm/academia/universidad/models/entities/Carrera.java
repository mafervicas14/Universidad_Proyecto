package com.ibm.academia.universidad.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="carreras", schema = "universidad")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede ser vacio")
    @Size(max = 80)
    @Column(name="nombre", unique = true, nullable = false, length = 80)
    private String nombre;

    @Positive(message = "Debe ser mayor a 0")
    @Column(name="cantidad_materias")
    private Integer cantidadMaterias;

    @Positive(message = "Debe ser mayor a 0")
    @Column(name="cantidad_anios")
    private Integer cantidadAnios;

    @Column(name="fecha_alta")
    private Date fechaAlta;

    @Column(name="fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"carrera"})
    private Set<Alumno> alumnos;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"carreras"})
    private Set<Profesor> profesores;

    public Carrera(Integer id, String nombre, Integer cantidadMaterias, Integer cantidadAnios) {
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

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
                '}';
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
