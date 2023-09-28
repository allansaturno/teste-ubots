package com.ubots.teste.model;

import com.ubots.teste.domain.GrupoDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The persistent class for the grupo database table.
 */
@Entity
@Table(name = "grupo")
@NamedQuery(name = "Grupo.findAll", query = "SELECT a FROM Grupo a")

@Getter
@Setter
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    private Long idGrupo;
    @Column(name = "ds_grupo")
    private String dsGrupo;
    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;
    @Column(name = "fl_status")
    private Boolean flStatus;
    @Column(name = "fl_deleted")
    private Boolean flDeleted;

    public static Grupo fromDomain(GrupoDomain grupoDomain) {
        if (Objects.isNull(grupoDomain))
            return null;

        return new ModelMapper().map(grupoDomain, Grupo.class);
    }

}
