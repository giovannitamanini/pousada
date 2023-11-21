package com.pousada.domain.repository;

import com.pousada.domain.entity.ReservaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaRepository extends CrudRepository<ReservaEntity, Integer> {

    List<ReservaEntity> findAll();
}
