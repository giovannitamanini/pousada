package com.pousada.service;

import com.pousada.domain.entity.HospedeEstadiaEntity;
import com.pousada.domain.entity.HospedeEstadiaId;
import com.pousada.domain.repository.HospedeEstadiaRepository;
import com.pousada.dto.HospedeEstadiaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HospedeEstadiaService {

    private final ModelMapper modelMapper;
    private final HospedeEstadiaRepository hospedeEstadiaRepository;

    public HospedeEstadiaService(ModelMapper modelMapper, HospedeEstadiaRepository hospedeEstadiaRepository) {
        this.modelMapper = modelMapper;
        this.hospedeEstadiaRepository = hospedeEstadiaRepository;
    }

    public HospedeEstadiaDTO salvarHospedeAcompanhante(HospedeEstadiaDTO hospedeEstadiaDTO) {

        HospedeEstadiaEntity hospedeEstadiaEntity = new HospedeEstadiaEntity();
        HospedeEstadiaId hospedeEstadiaId = new HospedeEstadiaId();
        System.out.println("HospedeEstadiaDTO = " + hospedeEstadiaDTO);


        hospedeEstadiaId.setIdHospede(hospedeEstadiaDTO.getIdHospede());
        hospedeEstadiaId.setIdEstadia(hospedeEstadiaDTO.getIdEstadia());

        hospedeEstadiaEntity.setHospedeEstadiaId(hospedeEstadiaId);

        HospedeEstadiaEntity hospedeEstadiaEntitySalva = hospedeEstadiaRepository.save(hospedeEstadiaEntity);

        HospedeEstadiaDTO hospedeEstadiaDTOSalvo = new HospedeEstadiaDTO();
        hospedeEstadiaDTOSalvo.setIdHospede(hospedeEstadiaEntitySalva.getHospedeEstadiaId().getIdHospede());
        hospedeEstadiaDTOSalvo.setIdEstadia(hospedeEstadiaEntitySalva.getHospedeEstadiaId().getIdEstadia());

        return hospedeEstadiaDTOSalvo;
    }
}
