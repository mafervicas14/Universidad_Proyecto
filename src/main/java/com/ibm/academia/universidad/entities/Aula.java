package com.ibm.academia.universidad.entities;

import com.ibm.academia.universidad.enums.Pizzaron;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name="aulas", schema = "universidad")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="numero_aula", nullable = false)
    private Integer numeroAula;

    @Column(name="medidas")
    private String medidas;

    @Column(name="cantidad_pupitres")
    private Integer cantidadPupitres;

    @Column(name="tipo_pizarron")
    @Enumerated(EnumType.STRING)
    private Pizzaron pizzaron;

    @Column(name="fecha_alta")
    private Date fechaAlta;

    @Column(name="fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Aula(Integer id, Integer numeroAula, String medidas, Integer cantidadPupitres, Pizzaron pizzaron) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.medidas = medidas;
        this.cantidadPupitres = cantidadPupitres;
        this.pizzaron = pizzaron;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aula)) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && numeroAula.equals(aula.numeroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroAula);
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
