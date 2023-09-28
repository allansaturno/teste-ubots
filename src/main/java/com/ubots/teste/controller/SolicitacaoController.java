package com.ubots.teste.controller;

import com.ubots.teste.domain.SolicitacaoDomain;
import com.ubots.teste.service.SolicitacaoService;
import com.ubots.teste.shared.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/solicitacao")
@RestController
public class SolicitacaoController {

	@Autowired
	private SolicitacaoService solicitacaoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
	
		List<com.ubots.teste.domain.SolicitacaoDomain> listaSolicitacao = solicitacaoService.findAll();
	
	    if (!listaSolicitacao.isEmpty()) {
	    	return ResponseService.setResponse(true, listaSolicitacao);
	    }
	
	    return ResponseService.setResponse(true, null);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByPk(@PathVariable Long id) {
	
		com.ubots.teste.domain.SolicitacaoDomain solicitacao =  solicitacaoService.findById(id);
	
	    if (solicitacao != null) {
	    	return ResponseService.setResponse(true, solicitacao);
	    }
		
	    return ResponseService.setResponse(true, null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
	
		solicitacaoService.delete(id);
	
	    return ResponseService.setResponse(true, null);
	    
	}
	
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody SolicitacaoDomain solicitacaoDomain) throws IllegalAccessException, InvocationTargetException {
	
		com.ubots.teste.domain.SolicitacaoDomain result = solicitacaoService.save(solicitacaoDomain);

		if(result!= null){
			return ResponseService.setResponse(true, result);
		}else{
			Map<String, String> erro = new HashMap<String, String>();
		    erro.put("message", "Erro na tentativa de edi��o dos dados");
			return ResponseService.setResponse(false, erro);
		}
    
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody SolicitacaoDomain solicitacaoDomain) {
	
		com.ubots.teste.domain.SolicitacaoDomain retorno = solicitacaoService.save(solicitacaoDomain);
	
	    if (retorno != null) {
	    	return ResponseService.setResponse(true, retorno);
	    }
		
		Map<String, String> erro = new HashMap<String, String>();
		erro.put("message", "Erro na tentativa de grava��o dos dados");
	    return ResponseService.setResponse(false, erro);
	}
	
}
