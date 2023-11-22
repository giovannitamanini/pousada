package com.pousada.domain.repository;

import com.pousada.domain.entity.AcomodacaoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcomodacaoRepository extends CrudRepository<AcomodacaoEntity, Integer> {

    List<AcomodacaoEntity> findAll();

}
