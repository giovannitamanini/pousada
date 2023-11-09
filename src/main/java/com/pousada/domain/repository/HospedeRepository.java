package com.pousada.domain.repository;

import com.pousada.domain.entity.HospedeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospedeRepository extends CrudRepository<HospedeEntity, Integer> {

}
