package com.pousada.controller;

import com.pousada.service.AcomodacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AcomodacaoController {

    private final AcomodacaoService acomodacaoService;
}
