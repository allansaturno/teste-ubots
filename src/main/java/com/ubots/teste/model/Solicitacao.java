package com.ubots.teste.model;

import com.ubots.teste.domain.SolicitacaoDomain;
import com.ubots.teste.enums.SituacaoSolicitacaoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The persistent class for the solicitacao database table.
 */
@Entity
@Table(name = "solicitacao")
@NamedQuery(name = "Solicitacao.findAll", query = "SELECT a FROM Solicitacao a")
@Getter
@Setter
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitacao")
    private Long idSolicitacao;
    @Column(name = "ds_nome_cliente")
    private String dsNomeCliente;
    @Column(name = "ds_solicitacao")
    private String dsSolicitacao;
    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;
    @Column(name = "fl_status")
    private Boolean flStatus;
    @Column(name = "fl_deleted")
    private Boolean flDeleted;
    @Column(name = "id_grupo")
    private Long idGrupo;
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "st_solicitacao")
    @Enumerated(EnumType.STRING)
    private SituacaoSolicitacaoEnum stSolicitacao;

    @OneToOne
    @JoinColumn(name = "id_usuario", updatable = false, insertable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_grupo", updatable = false, insertable = false)
    private Grupo grupo;

    public static Solicitacao fromDomain(SolicitacaoDomain solicitacaoDomain) {
        if (Objects.isNull(solicitacaoDomain))
            return null;

        return new ModelMapper().map(solicitacaoDomain, Solicitacao.class);
    }

}
