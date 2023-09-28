package com.ubots.teste.domain;

import com.ubots.teste.model.Grupo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Objects;



@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class GrupoDomain {

    private Long idGrupo;
    private String dsGrupo;
    private LocalDateTime dtCriacao;
    private Boolean flStatus;
    private Boolean flDeleted;

    public static GrupoDomain fromEntity(Grupo grupo) {
        if (Objects.isNull(grupo))
            return null;

        return new ModelMapper().map(grupo, GrupoDomain.class);
    }

}
