package com.pousada.service;

import com.pousada.domain.entity.ReservaEntity;
import com.pousada.domain.repository.ReservaRepository;
import com.pousada.dto.ReservaDTO;
import com.pousada.exception.ReservaNaoEncontradaException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ReservaDTO buscarReservaPorId(int id) {
        ReservaEntity reservaEntity = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNaoEncontradaException("A reserva com o ID " + id + " não existe."));

        return modelMapper.map(reservaEntity, ReservaDTO.class);
    }

    public List<ReservaDTO> buscarTodasReservas() {
        List<ReservaEntity> reservaEntities = reservaRepository.findAll();

        if (reservaEntities.isEmpty())
            throw new ReservaNaoEncontradaException("Nenhuma reserva está registrada!");

        List<ReservaDTO> reservaDTOs = reservaEntities.stream()
                .map(reservaEntity -> modelMapper.map(reservaEntity, ReservaDTO.class))
                .collect(Collectors.toList());

        return reservaDTOs;
    }

    public void deletarReservaPorId(int id) {
        boolean reservaExiste = reservaRepository.existsById(id);

        if (reservaExiste) {
            reservaRepository.deleteById(id);
        } else {
            throw new ReservaNaoEncontradaException("A reserva com o ID " + id + " não existe.");
        }
    }

}
