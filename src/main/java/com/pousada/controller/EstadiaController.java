package com.pousada.controller;

import com.pousada.dto.EstadiaDTO;
import com.pousada.service.EstadiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EstadiaController {

    private final EstadiaService estadiaService;

    public EstadiaDTO iniciarEstadia(@RequestBody EstadiaDTO estadia) {
        return estadiaService.iniciarEstadia(estadia);
    }

}
