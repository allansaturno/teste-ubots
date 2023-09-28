package com.ubots.teste.model;

import com.ubots.teste.domain.UsuarioDomain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The persistent class for the usuario database table.
 */
@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT a FROM Usuario a")

@Getter
@Setter
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "ds_nome")
    private String dsNome;
    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;
    @Column(name = "fl_status")
    private Boolean flStatus;
    @Column(name = "fl_deleted")
    private Boolean flDeleted;
    @Column(name = "id_grupo")
    private Long idGrupo;

    public static Usuario fromDomain(UsuarioDomain usuarioDomain) {
        if (Objects.isNull(usuarioDomain))
            return null;

        return new ModelMapper().map(usuarioDomain, Usuario.class);
    }

}
