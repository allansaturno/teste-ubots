package com.ubots.teste.domain;

import com.ubots.teste.enums.SituacaoSolicitacaoEnum;
import com.ubots.teste.model.Solicitacao;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Objects;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoDomain {

    private Long idSolicitacao;
    private String dsNomeCliente;
    private String dsSolicitacao;
    private LocalDateTime dtCriacao;
    private Boolean flStatus;
    private Boolean flDeleted;
    private Long idGrupo;
    @With
    private Long idUsuario;
    private SituacaoSolicitacaoEnum stSolicitacao;

    public static SolicitacaoDomain fromEntity(Solicitacao solicitacao) {
        if (Objects.isNull(solicitacao))
            return null;

        return new ModelMapper().map(solicitacao, SolicitacaoDomain.class);
    }

}
