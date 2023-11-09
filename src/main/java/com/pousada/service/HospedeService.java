package com.pousada.service;

import com.pousada.domain.entity.HospedeEntity;
import com.pousada.domain.repository.HospedeRepository;
import com.pousada.dto.HospedeDTO;
import com.pousada.exception.HospedeNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HospedeService {

    private final ModelMapper modelMapper;
    private final HospedeRepository hospedeRepository;

    public HospedeService(ModelMapper modelMapper, HospedeRepository hospedeRepository) {
        this.modelMapper = modelMapper;
        this.hospedeRepository = hospedeRepository;
    }

    public HospedeDTO criarHospede(HospedeDTO hospedeDTO) {
        HospedeEntity hospedeEntity = modelMapper.map(hospedeDTO, HospedeEntity.class);
        HospedeEntity hospedeEntitySalvo = hospedeRepository.save(hospedeEntity);
        return modelMapper.map(hospedeEntitySalvo, HospedeDTO.class);
    }

    public HospedeDTO buscarHospedePorId(int id) {
        HospedeEntity hospedeEntity = hospedeRepository.findById(id)
                .orElseThrow(() -> new HospedeNaoEncontradoException("O hóspede com o ID " + id + " não existe."));

        return modelMapper.map(hospedeEntity, HospedeDTO.class);
    }

    public void deletarHospedePorId(int id) {
        boolean hospedeExiste = hospedeRepository.existsById(id);

        if (hospedeExiste) {
            hospedeRepository.deleteById(id);
        } else {
            throw new HospedeNaoEncontradoException("O hóspede com o ID " + id + " não existe.");
        }
    }

}
