package com.api.bet.service;

import com.api.bet.model.Apostador;
import com.api.bet.model.dto.ApostadorIn;
import com.api.bet.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApostadorService {

    private final ApostadorRepository apostadorRepository;
    private final ModelMapper modelMapper;

    public void salvaApostador(ApostadorIn apostadorIn){
        Apostador apostador = modelMapper.map(apostadorIn, Apostador.class);
        apostadorRepository.save(apostador);
    }
}
