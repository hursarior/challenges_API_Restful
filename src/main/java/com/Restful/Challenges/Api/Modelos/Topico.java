package com.Restful.Challenges.Api.Modelos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Topicos")
@Data
@NoArgsConstructor
public class Topico {

    public Topico(DtoTopico dtotopico) {

        this.titulo =dtotopico.titulo();
        this.mensaje = dtotopico.mensaje();
        this.autor = dtotopico.autor();
        this.curso = dtotopico.curso();
        this.estatus_topico = dtotopico.estatus_tpc();
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDate fecha_Created = LocalDate.now();

    private String estatus_topico;

    private String autor;

    private String curso;


}

