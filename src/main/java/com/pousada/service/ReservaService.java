package com.pousada.service;

import com.pousada.domain.entity.ReservaEntity;
import com.pousada.domain.repository.ReservaRepository;
import com.pousada.dto.ReservaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ModelMapper modelMapper;
    private final ReservaRepository reservaRepository;

    public ReservaService(ModelMapper modelMapper, ReservaRepository reservaRepository) {
        this.modelMapper = modelMapper;
        this.reservaRepository = reservaRepository;
    }

    public ReservaDTO criarReserva(ReservaDTO reservaDTO) {
        ReservaEntity reservaEntity = modelMapper.map(reservaDTO, ReservaEntity.class);
        ReservaEntity reservaEntitySalva = reservaRepository.save(reservaEntity);
        return modelMapper.map(reservaEntitySalva, ReservaDTO.class);
    }

}
