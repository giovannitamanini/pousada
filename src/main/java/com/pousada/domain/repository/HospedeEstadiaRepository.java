package com.pousada.domain.repository;

import com.pousada.domain.entity.HospedeEstadiaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeEstadiaRepository extends CrudRepository<HospedeEstadiaEntity, Integer> {


}
