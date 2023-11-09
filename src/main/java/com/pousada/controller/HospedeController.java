package com.pousada.controller;

import com.pousada.dto.HospedeDTO;
import com.pousada.service.HospedeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HospedeController {

    private final HospedeService hospedeService;

    @PostMapping("/hospedes")
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeDTO criarHospede(@RequestBody HospedeDTO hospede) {
        return hospedeService.criarHospede(hospede);
    }

    @GetMapping("/hospedes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HospedeDTO buscarHospedePorId(@PathVariable int id) {
        return hospedeService.buscarHospedePorId(id);
    }

    @DeleteMapping("/hospedes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarHospedePorId(@PathVariable int id) {
        hospedeService.deletarHospedePorId(id);
    }
}
