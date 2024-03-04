package com.pousada.controller;

import com.pousada.dto.ReservaDTO;
import com.pousada.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Operation(summary = "Faz o cadastro de uma nova reserva")
    @PostMapping("/reservas")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaDTO criarReserva(@RequestBody ReservaDTO reserva) {
        return reservaService.criarReserva(reserva);
    }

    @Operation(summary = "Busca uma reserva pelo Id de registro da mesma")
    @GetMapping("/reservas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservaDTO buscarReservaPorId(@PathVariable int id) {
        return reservaService.buscarReservaPorId(id);
    }

    @Operation(summary = "Busca todas as reservas cadastradas")
    @GetMapping("/reservas")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDTO> buscarTodasReservas() {
        return reservaService.buscarTodasReservas();
    }

    @Operation(summary = "Faz a exclusão do registro de uma reserva pelo Id da mesma")
    @DeleteMapping("/reservas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarReservaPorId(@PathVariable int id) {
        reservaService.deletarReservaPorId(id);
    }

    @Operation(summary = "Busca todas as reservas que estão com status 'em espera'. Ou seja, reservas que ainda não tornaram-se estadias.")
    @GetMapping("/reservas/em_espera")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDTO> buscarReservasEmEspera() {
        return reservaService.buscarReservasEmEspera();
    }
}
