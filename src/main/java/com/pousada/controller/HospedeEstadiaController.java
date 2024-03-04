package com.pousada.controller;

import com.pousada.dto.HospedeEstadiaDTO;
import com.pousada.service.HospedeEstadiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Acompanhantes")
public class HospedeEstadiaController {

    @Autowired
    private final HospedeEstadiaService hospedeEstadiaService;

    @Operation(summary = "A partir do Id da Estadia iniciada com um hóspede principal, vincula um hóspede acompanhante à mesma")
    @PostMapping("/hospedeEstadia")
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeEstadiaDTO salvarHospedeAcompanhante(@RequestBody HospedeEstadiaDTO hospedeEstadiaDTO) {
        return hospedeEstadiaService.salvarHospedeAcompanhante(hospedeEstadiaDTO);
    }
}