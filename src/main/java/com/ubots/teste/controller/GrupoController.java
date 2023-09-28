package com.ubots.teste.controller;

import com.ubots.teste.domain.GrupoDomain;
import com.ubots.teste.service.GrupoService;
import com.ubots.teste.shared.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/grupo")
@RestController
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {

        List<GrupoDomain> listaGrupo = grupoService.findAll();

        if (!listaGrupo.isEmpty()) {
            return ResponseService.setResponse(true, listaGrupo);
        }

        return ResponseService.setResponse(true, null);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByPk(@PathVariable Long id) {

        GrupoDomain grupo = grupoService.findById(id);

        if (grupo != null) {
            return ResponseService.setResponse(true, grupo);
        }

        return ResponseService.setResponse(true, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        grupoService.delete(id);

        return ResponseService.setResponse(true, null);

    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody GrupoDomain grupoDomain) throws IllegalAccessException, InvocationTargetException {

        GrupoDomain result = grupoService.save(grupoDomain);

        if (result != null) {
            return ResponseService.setResponse(true, result);
        } else {
            Map<String, String> erro = new HashMap<String, String>();
            erro.put("message", "Erro na tentativa de edi��o dos dados");
            return ResponseService.setResponse(false, erro);
        }

    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GrupoDomain grupoDomain) {

        GrupoDomain retorno = grupoService.save(grupoDomain);

        if (retorno != null) {
            return ResponseService.setResponse(true, retorno);
        }

        Map<String, String> erro = new HashMap<String, String>();
        erro.put("message", "Erro na tentativa de grava��o dos dados");
        return ResponseService.setResponse(false, erro);
    }

}
