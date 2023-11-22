package com.pousada.domain.repository;

import com.pousada.domain.entity.ReservaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<ReservaEntity, Integer> {

    List<ReservaEntity> findAll();
}
