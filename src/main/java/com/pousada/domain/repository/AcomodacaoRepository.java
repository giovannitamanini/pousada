package com.pousada.domain.repository;

import com.pousada.domain.entity.AcomodacaoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AcomodacaoRepository extends CrudRepository<AcomodacaoEntity, Integer> {

    List<AcomodacaoEntity> findAll();

}
