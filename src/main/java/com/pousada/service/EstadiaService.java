package com.pousada.service;

import com.pousada.domain.entity.EstadiaEntity;
import com.pousada.domain.entity.HospedeEntity;
import com.pousada.domain.entity.ReservaEntity;
import com.pousada.domain.repository.EstadiaRepository;
import com.pousada.domain.repository.ReservaRepository;
import com.pousada.dto.EstadiaDTO;
import com.pousada.dto.ReservaDTO;
import com.pousada.enums.StatusEstadiaEnum;
import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import com.pousada.exception.EstadiaNaoEncontradaException;
import com.pousada.exception.ReservaNaoEncontradaException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadiaService {

    private final ModelMapper modelMapper;

    private final ReservaRepository reservaRepository;

    private final EstadiaRepository estadiaRepository;

    public EstadiaService(ModelMapper modelMapper, ReservaRepository reservaRepository, EstadiaRepository estadiaRepository) {
        this.modelMapper = modelMapper;
        this.reservaRepository = reservaRepository;
        this.estadiaRepository = estadiaRepository;
    }

    //A partir dos dados no front-end da reserva, mando a requisição de criação da estadia no BD
    public EstadiaDTO iniciarEstadia(ReservaDTO reservaDTO) {
        ReservaEntity reservaExistente = reservaRepository.findById(reservaDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
        reservaExistente.setStatusReserva(StatusReservaEnum.CONFIRMADA);
        reservaRepository.save(reservaExistente);

        EstadiaDTO estadiaDTO = new EstadiaDTO();

        StatusPagamentoEnum statusPagamentoReserva = reservaDTO.getStatusPagamento();

        if (statusPagamentoReserva == StatusPagamentoEnum.PENDENTE) {
            estadiaDTO.setCheckIn(reservaDTO.getCheckIn());
            estadiaDTO.setCheckOut(reservaDTO.getCheckOut());
            estadiaDTO.setNumeroPernoites(reservaDTO.getNumeroPernoites());
            estadiaDTO.setCusto(reservaDTO.getCusto());
            estadiaDTO.setStatusPagamento(reservaDTO.getStatusPagamento());
            estadiaDTO.setIdAcomodacao(reservaDTO.getIdAcomodacao());
            estadiaDTO.setIdHospede(reservaDTO.getIdHospede());
            estadiaDTO.setIdReserva(reservaDTO.getId());
        } else if (statusPagamentoReserva == StatusPagamentoEnum.EFETUADO) {
            estadiaDTO.setCheckIn(reservaDTO.getCheckIn());
            estadiaDTO.setCheckOut(reservaDTO.getCheckOut());
            estadiaDTO.setNumeroPernoites(reservaDTO.getNumeroPernoites());
            estadiaDTO.setCusto(0.00);
            estadiaDTO.setStatusPagamento(StatusPagamentoEnum.PENDENTE);
            estadiaDTO.setIdAcomodacao(reservaDTO.getIdAcomodacao());
            estadiaDTO.setIdHospede(reservaDTO.getIdHospede());
            estadiaDTO.setIdReserva(reservaDTO.getId());
        } else {
            throw new IllegalArgumentException("Status de pagamento inválido.");
        }

        EstadiaEntity estadiaEntity = modelMapper.map(estadiaDTO, EstadiaEntity.class);
        EstadiaEntity estadiaEntitySalva = estadiaRepository.save(estadiaEntity);

        return modelMapper.map(estadiaEntitySalva, EstadiaDTO.class);
    }

    public List<EstadiaDTO> buscarTodasEstadias() {
        List<EstadiaEntity> estadiaEntities = estadiaRepository.findAll();

        if (estadiaEntities.isEmpty())
            throw new EstadiaNaoEncontradaException("Nenhuma estadia está registrada!");

        List<EstadiaDTO> estadiaDTOs = estadiaEntities.stream()
                .map(estadiaEntity -> modelMapper.map(estadiaEntity, EstadiaDTO.class))
                .collect(Collectors.toList());

        return estadiaDTOs;
    }

    public EstadiaDTO finalizarEstadia(int id) {
        EstadiaEntity estadiaEntity = estadiaRepository.findById(id)
                        .orElseThrow(() -> new EstadiaNaoEncontradaException("A estadia com o ID " + id + " não existe."));

        estadiaEntity.setStatusEstadia(StatusEstadiaEnum.FINALIZADA);
        EstadiaEntity estadiaeEntitySalva = estadiaRepository.save(estadiaEntity);

        return modelMapper.map(estadiaeEntitySalva, EstadiaDTO.class);
    }

    public List<EstadiaDTO> buscarEstadiasEmAndamento() {
        List<EstadiaEntity> estadiaEntities = estadiaRepository.buscarEstadiasEmAndamento();

        if (estadiaEntities.isEmpty())
            throw new EstadiaNaoEncontradaException("Nenhuma estadia em andamento!");

        List<EstadiaDTO> estadiaDTOs = estadiaEntities.stream()
                .map(estadiaEntity -> modelMapper.map(estadiaEntity, EstadiaDTO.class))
                .collect(Collectors.toList());

        return estadiaDTOs;
    }
}

