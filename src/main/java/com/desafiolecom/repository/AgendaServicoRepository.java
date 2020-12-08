package com.desafiolecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolecom.entity.AgendaServicoEntity;

@Repository
public interface AgendaServicoRepository extends JpaRepository<AgendaServicoEntity, Long>{

}
