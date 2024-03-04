package com.pousada.controller;

import com.pousada.dto.HospedeDTO;
import com.pousada.service.HospedeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Hóspedes")
public class HospedeController {

    private final HospedeService hospedeService;

    @Operation(summary = "Cadastra um novo hóspede")
    @PostMapping("/hospedes")
    @ResponseStatus(HttpStatus.CREATED)
    public HospedeDTO criarHospede(@RequestBody HospedeDTO hospede) {
        return hospedeService.criarHospede(hospede);
    }

    @Operation(summary = "Busca hóspede pelo Id de registro")
    @GetMapping("/hospedes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HospedeDTO buscarHospedePorId(@PathVariable int id) {
        return hospedeService.buscarHospedePorId(id);
    }

    @Operation(summary = "Busca hóspedes pelo primeiro nome")
    @GetMapping("/hospedes/nomes/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<HospedeDTO> buscarHospedesPorNome(@PathVariable String nome) {
        return hospedeService.buscarHospedesPorNome(nome);
    }

    @Operation(summary = "Busca todos os hóspedes cadastrados")
    @GetMapping("/hospedes")
    @ResponseStatus(HttpStatus.OK)
    public List<HospedeDTO> buscarTodosHospedes() {
        return hospedeService.buscarTodosHospedes();
    }

    @Operation(summary = "Faz a exclusão do cadastro do hóspede")
    @DeleteMapping("/hospedes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarHospedePorId(@PathVariable int id) {
        hospedeService.deletarHospedePorId(id);
    }
}
