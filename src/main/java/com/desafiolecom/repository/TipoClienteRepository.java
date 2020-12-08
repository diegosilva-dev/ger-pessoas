package com.desafiolecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolecom.entity.TipoClienteEntity;

@Repository
public interface TipoClienteRepository extends JpaRepository<TipoClienteEntity, Long>{

}