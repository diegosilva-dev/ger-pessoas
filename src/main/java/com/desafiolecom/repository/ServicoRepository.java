package com.desafiolecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolecom.entity.ServicoEntity;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Long>{

}
