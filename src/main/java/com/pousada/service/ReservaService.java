package com.pousada.service;

import com.pousada.domain.entity.EstadiaEntity;
import com.pousada.domain.entity.ReservaEntity;
import com.pousada.domain.repository.AcomodacaoRepository;
import com.pousada.domain.repository.EstadiaRepository;
import com.pousada.domain.repository.ReservaRepository;
import com.pousada.dto.ReservaDTO;
import com.pousada.enums.StatusEstadiaEnum;
import com.pousada.enums.StatusReservaEnum;
import com.pousada.exception.AcomodacaoOcupadaException;
import com.pousada.exception.ReservaNaoEncontradaException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ModelMapper modelMapper;
    private final ReservaRepository reservaRepository;

    private final EstadiaRepository estadiaRepository;

    private final AcomodacaoRepository acomodacaoRepository;

    public ReservaService(ModelMapper modelMapper, ReservaRepository reservaRepository, EstadiaRepository estadiaRepository, AcomodacaoRepository acomodacaoRepository) {
        this.modelMapper = modelMapper;
        this.reservaRepository = reservaRepository;
        this.estadiaRepository = estadiaRepository;
        this.acomodacaoRepository = acomodacaoRepository;
    }

    public ReservaDTO criarReserva(ReservaDTO reservaDTO) {
        if (existeReservaNoPeriodo(reservaDTO)) {
            throw new AcomodacaoOcupadaException("A acomodação requisitada já possui reserva no período solicitado!");
        } else if (existeEstadiaNoPeriodo(reservaDTO)) {
            throw new AcomodacaoOcupadaException("A acomodação requisitada possui estadia em curso no período solicitado!");
        }

        ReservaEntity reservaEntity = modelMapper.map(reservaDTO, ReservaEntity.class);
        reservaEntity.setNumeroPernoites((int) ChronoUnit.DAYS.between(reservaEntity.getCheckIn(), reservaEntity.getCheckOut()));
        double custoDiariaAcomodacao = acomodacaoRepository.buscarValorDiariaPorId(reservaEntity.getIdAcomodacao());
        double custoReserva = custoDiariaAcomodacao * reservaEntity.getNumeroPernoites();
        reservaEntity.setCusto(custoReserva);
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

    private boolean existeReservaNoPeriodo(ReservaDTO novaReserva) {
        ReservaEntity reservaEntity = reservaRepository.buscarReservaPorAcomodacaoEPeriodo(
                novaReserva.getIdAcomodacao(),
                novaReserva.getCheckIn(),
                novaReserva.getCheckOut()
        );

        if (reservaEntity == null)
            return false;

        if (reservaEntity.getStatusReserva() == StatusReservaEnum.CONFIRMADA)
            return false;

        return true;
    }

    public boolean existeEstadiaNoPeriodo(ReservaDTO novaReserva) {
        EstadiaEntity estadiaEntity = estadiaRepository.buscarEstadiaPorAcomodacaoEPeriodo(
                novaReserva.getIdAcomodacao(),
                novaReserva.getCheckIn()
        );

        if (estadiaEntity == null)
            return false;

        if (estadiaEntity.getStatusEstadia() == StatusEstadiaEnum.FINALIZADA)
            return false;

        return true;
    }

    public List<ReservaDTO> buscarReservasEmEspera() {
        List<ReservaEntity> reservaEntities = reservaRepository.buscarReservasEmEspera();

        if (reservaEntities.isEmpty())
            throw new ReservaNaoEncontradaException("Nenhuma reserva em espera!");

        List<ReservaDTO> reservaDTOs = reservaEntities.stream()
                .map(reservaEntity -> modelMapper.map(reservaEntity, ReservaDTO.class))
                .collect(Collectors.toList());

        return reservaDTOs;
    }

}
