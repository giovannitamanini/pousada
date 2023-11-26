package com.pousada.domain.repository;

import com.pousada.domain.entity.EstadiaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EstadiaRepository extends CrudRepository<EstadiaEntity, Integer> {

    List<EstadiaEntity> findAll();

    @Query(value = "SELECT * FROM estadia WHERE id_acomodacao = :idAcomodacao AND (:checkIn < check_out)",
            nativeQuery = true)
    EstadiaEntity buscarEstadiaPorAcomodacaoEPeriodo(
            @Param("idAcomodacao") int idAcomodacao,
            @Param("checkIn") LocalDate checkIn);

    @Query(value = "SELECT * FROM estadia WHERE status_estadia = 'EM_ANDAMENTO'",
            nativeQuery = true)
    List<EstadiaEntity> buscarEstadiasEmAndamento();

}
