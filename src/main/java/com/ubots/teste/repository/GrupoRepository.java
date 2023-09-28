package com.ubots.teste.repository;

import com.ubots.teste.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}

