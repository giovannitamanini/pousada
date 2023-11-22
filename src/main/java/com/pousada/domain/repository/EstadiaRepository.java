package com.pousada.domain.repository;

import com.pousada.domain.entity.EstadiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadiaRepository extends CrudRepository<EstadiaEntity, Integer> {
}
