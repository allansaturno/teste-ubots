package com.ubots.teste.controller;

import com.ubots.teste.domain.UsuarioDomain;
import com.ubots.teste.service.UsuarioService;
import com.ubots.teste.shared.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {

        List<UsuarioDomain> listaUsuario = usuarioService.findAll();

        if (!listaUsuario.isEmpty()) {
            return ResponseService.setResponse(true, listaUsuario);
        }

        return ResponseService.setResponse(true, null);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByPk(@PathVariable Long id) {

        UsuarioDomain usuario = usuarioService.findById(id);

        if (usuario != null) {
            return ResponseService.setResponse(true, usuario);
        }

        return ResponseService.setResponse(true, null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        usuarioService.delete(id);

        return ResponseService.setResponse(true, null);

    }


    @PutMapping
    public ResponseEntity<?> update(@RequestBody UsuarioDomain usuarioDomain) throws IllegalAccessException, InvocationTargetException {

        UsuarioDomain result = usuarioService.save(usuarioDomain);

        if (result != null) {
            return ResponseService.setResponse(true, result);
        } else {
            Map<String, String> erro = new HashMap<String, String>();
            erro.put("message", "Erro na tentativa de edi��o dos dados");
            return ResponseService.setResponse(false, erro);
        }

    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UsuarioDomain usuarioDomain) {

        UsuarioDomain retorno = usuarioService.save(usuarioDomain);

        if (retorno != null) {
            return ResponseService.setResponse(true, retorno);
        }

        Map<String, String> erro = new HashMap<String, String>();
        erro.put("message", "Erro na tentativa de grava��o dos dados");
        return ResponseService.setResponse(false, erro);
    }

}
