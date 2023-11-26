package com.pousada.controller;

import com.pousada.dto.EstadiaDTO;
import com.pousada.dto.ReservaDTO;
import com.pousada.service.EstadiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EstadiaController {

    private final EstadiaService estadiaService;

    @PostMapping("/estadias")
    @ResponseStatus(HttpStatus.CREATED)
    public EstadiaDTO iniciarEstadia(@RequestBody ReservaDTO reserva) {
        return estadiaService.iniciarEstadia(reserva);
    }

    @GetMapping("/estadias")
    @ResponseStatus(HttpStatus.OK)
    public List<EstadiaDTO> buscarTodasEstadias() {
        return estadiaService.buscarTodasEstadias();
    }

    @PutMapping("/estadias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstadiaDTO finalizarEstadia(@PathVariable int id) {
        return estadiaService.finalizarEstadia(id);
    }

    @GetMapping("/estadias/em_andamento")
    @ResponseStatus(HttpStatus.OK)
    public List<EstadiaDTO> buscarEstadiasEmAndamento() {
        return estadiaService.buscarEstadiasEmAndamento();
    }

}
