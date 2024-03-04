package com.pousada.controller;

import com.pousada.dto.EstadiaDTO;
import com.pousada.dto.ReservaDTO;
import com.pousada.service.EstadiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Estadias")
public class EstadiaController {

    @Autowired
    private final EstadiaService estadiaService;

    @Operation(summary = "Inicia uma estadia a partir de uma reserva em espera")
    @PostMapping("/estadias")
    @ResponseStatus(HttpStatus.CREATED)
    public EstadiaDTO iniciarEstadia(@RequestBody ReservaDTO reserva) {
        return estadiaService.iniciarEstadia(reserva);
    }

    @Operation(summary = "Busca todas as estadias cadastradas")
    @GetMapping("/estadias")
    @ResponseStatus(HttpStatus.OK)
    public List<EstadiaDTO> buscarTodasEstadias() {
        return estadiaService.buscarTodasEstadias();
    }

    @Operation(summary = "Finaliza uma estadia a partir do seu Id")
    @PutMapping("/estadias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EstadiaDTO finalizarEstadia(@PathVariable int id) {
        return estadiaService.finalizarEstadia(id);
    }

    @Operation(summary = "Busca todas as estadias em andamento na pousada")
    @GetMapping("/estadias/em_andamento")
    @ResponseStatus(HttpStatus.OK)
    public List<EstadiaDTO> buscarEstadiasEmAndamento() {
        return estadiaService.buscarEstadiasEmAndamento();
    }

}
