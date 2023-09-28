package com.ubots.teste.repository;

import com.ubots.teste.domain.AvailableDomain;
import com.ubots.teste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT new com.ubots.teste.domain.AvailableDomain(U.idUsuario, COUNT(S)) FROM Usuario U " +
            "LEFT OUTER JOIN Solicitacao S " +
            "ON U.idUsuario = S.idUsuario " +
            "AND U.idGrupo = S.idGrupo " +
            "AND S.stSolicitacao = 'OPEN' " +
            "WHERE U.idGrupo = :idGrupo " +
            "GROUP BY U.idUsuario " +
            "HAVING COUNT(S) < 3 " +
            "ORDER BY COUNT(S) ASC")
    List<AvailableDomain> findAvailable(Long idGrupo);
}

