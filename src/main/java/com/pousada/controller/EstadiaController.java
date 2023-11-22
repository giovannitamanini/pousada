package com.pousada.controller;

import com.pousada.dto.EstadiaDTO;
import com.pousada.dto.ReservaDTO;
import com.pousada.service.EstadiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
