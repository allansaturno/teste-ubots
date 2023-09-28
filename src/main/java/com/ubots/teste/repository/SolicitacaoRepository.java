package com.ubots.teste.repository;

import com.ubots.teste.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

    List<Solicitacao> findByIdUsuarioIsNull();
}

