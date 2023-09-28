package com.ubots.teste.domain;

import com.ubots.teste.model.Usuario;
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
public class UsuarioDomain {

    private Long idUsuario;
    private String dsNome;
    private LocalDateTime dtCriacao;
    private Boolean flStatus;
    private Boolean flDeleted;
    private Integer idGrupo;

    public static UsuarioDomain fromEntity(Usuario usuario) {
        if (Objects.isNull(usuario))
            return null;

        return new ModelMapper().map(usuario, UsuarioDomain.class);
    }

}
