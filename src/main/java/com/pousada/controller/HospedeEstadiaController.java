package com.pousada.controller;

import com.pousada.dto.HospedeEstadiaDTO;
import com.pousada.service.HospedeEstadiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HospedeEstadiaController {

    private final HospedeEstadiaService hospedeEstadiaService;

    @PostMapping("/hospedeEstadia")
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeEstadiaDTO salvarHospedeAcompanhante(@RequestBody HospedeEstadiaDTO hospedeEstadiaDTO) {
        return hospedeEstadiaService.salvarHospedeAcompanhante(hospedeEstadiaDTO);
    }
}