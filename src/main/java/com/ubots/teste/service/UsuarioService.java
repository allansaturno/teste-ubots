package com.ubots.teste.service;

import com.ubots.teste.domain.AvailableDomain;
import com.ubots.teste.domain.UsuarioDomain;
import com.ubots.teste.model.Usuario;
import com.ubots.teste.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDomain> findAll() {
        return usuarioRepository.findAll().stream().map(UsuarioDomain::fromEntity).collect(Collectors.toList());
    }

    public UsuarioDomain findById(Long id) {
        return UsuarioDomain.fromEntity(usuarioRepository.getOne(id));
    }

    public UsuarioDomain save(UsuarioDomain usuarioDomain) {
        return UsuarioDomain.fromEntity(usuarioRepository.save(Usuario.fromDomain(usuarioDomain)));
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDomain update(Usuario usuario) {
        return UsuarioDomain.fromEntity(usuarioRepository.save(usuario));
    }

    public List<AvailableDomain> findAvailable(Long idGrupo) {
        return usuarioRepository.findAvailable(idGrupo);
    }
}


