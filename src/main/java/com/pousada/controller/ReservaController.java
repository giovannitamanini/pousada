package com.pousada.controller;

import com.pousada.dto.ReservaDTO;
import com.pousada.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping("/reservas")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaDTO criarReserva(@RequestBody ReservaDTO reserva) {
        return reservaService.criarReserva(reserva);
    }

    @GetMapping("/reservas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservaDTO buscarReservaPorId(@PathVariable int id) {
        return reservaService.buscarReservaPorId(id);
    }

    @GetMapping("/reservas")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDTO> buscarTodasReservas() {
        return reservaService.buscarTodasReservas();
    }

    @DeleteMapping("/reservas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarReservaPorId(@PathVariable int id) {
        reservaService.deletarReservaPorId(id);
    }
}
