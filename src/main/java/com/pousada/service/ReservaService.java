package com.pousada.service;

import com.pousada.domain.entity.Reserva;
import com.pousada.domain.repository.ReservaRepository;
import com.pousada.dto.ReservaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
        Reserva reservaSalva = reservaRepository.save(reserva);
        return modelMapper.map(reservaSalva, ReservaDTO.class);
    }

}
