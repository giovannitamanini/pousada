package com.pousada.service;

import com.pousada.domain.repository.EstadiaRepository;
import com.pousada.domain.repository.ReservaRepository;
import com.pousada.dto.EstadiaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EstadiaService {

    private final ModelMapper modelMapper;

    private final EstadiaRepository estadiaRepository;

    public EstadiaService(ModelMapper modelMapper, EstadiaRepository estadiaRepository) {
        this.modelMapper = modelMapper;
        this.estadiaRepository = estadiaRepository;
    }

    public EstadiaDTO iniciarEstadia(EstadiaDTO estadiaDTO) {
        return estadiaDTO;
    }

}

