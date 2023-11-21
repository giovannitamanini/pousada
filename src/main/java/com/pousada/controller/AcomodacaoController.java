package com.pousada.controller;

import com.pousada.dto.AcomodacaoDTO;
import com.pousada.service.AcomodacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AcomodacaoController {

    @Autowired
    private final AcomodacaoService acomodacaoService;

    @GetMapping("/acomodacoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AcomodacaoDTO buscarAcomodacaoPorId(@PathVariable int id) {
        return acomodacaoService.buscarAcomodacaoPorId(id);
    }

    @GetMapping("/acomodacoes")
    @ResponseStatus(HttpStatus.OK)
    public List<AcomodacaoDTO> buscarTodasAcomodacoes() {
       return acomodacaoService.buscarTodasAcomodacoes();
    }

}
