package com.pousada.domain.repository;

import com.pousada.domain.entity.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
}
