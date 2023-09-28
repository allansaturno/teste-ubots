package com.ubots.teste.service;

import com.ubots.teste.domain.SolicitacaoDomain;
import com.ubots.teste.model.Solicitacao;
import com.ubots.teste.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitacaoService {

	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	
	public List<SolicitacaoDomain> findAll(){
		return solicitacaoRepository.findAll().stream().map(SolicitacaoDomain::fromEntity).collect(Collectors.toList());
	}

	public SolicitacaoDomain findById(Long id){
		return SolicitacaoDomain.fromEntity(solicitacaoRepository.getOne(id));
	}

	public SolicitacaoDomain save(SolicitacaoDomain solicitacaoDomain){
		return SolicitacaoDomain.fromEntity(solicitacaoRepository.save(Solicitacao.fromDomain(solicitacaoDomain)));
	}

	public void delete(Long id){
		solicitacaoRepository.deleteById(id);
	}
	
	public SolicitacaoDomain update(Solicitacao solicitacao){
		return SolicitacaoDomain.fromEntity(solicitacaoRepository.save(solicitacao));
	}

	public List<SolicitacaoDomain> findByIdUsuarioIsNull() {
		return solicitacaoRepository.findByIdUsuarioIsNull().stream().map(SolicitacaoDomain::fromEntity).collect(Collectors.toList());
	}
}


