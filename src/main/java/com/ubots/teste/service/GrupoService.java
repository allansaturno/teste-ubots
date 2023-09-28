package com.ubots.teste.service;

import com.ubots.teste.domain.GrupoDomain;
import com.ubots.teste.model.Grupo;
import com.ubots.teste.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<GrupoDomain> findAll() {
        return grupoRepository.findAll().stream().map(GrupoDomain::fromEntity).collect(Collectors.toList());
    }

    public GrupoDomain findById(Long id) {
        return GrupoDomain.fromEntity(grupoRepository.getOne(id));
    }

    public GrupoDomain save(GrupoDomain grupoDomain) {
        return GrupoDomain.fromEntity(grupoRepository.save(Grupo.fromDomain(grupoDomain)));
    }

    public void delete(Long id) {
        grupoRepository.deleteById(id);
    }

    public GrupoDomain update(Grupo grupo) {
        return GrupoDomain.fromEntity(grupoRepository.save(grupo));
    }
}


