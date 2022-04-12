package com.api.bet.service;

import com.api.bet.model.Apostador;
import com.api.bet.model.dto.Aposta;
import com.api.bet.model.dto.ApostaIn;
import com.api.bet.model.dto.ApostaOut;
import com.api.bet.repository.ApostaRepository;
import com.api.bet.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApostaService {

    private final ApostadorRepository apostadorRepository;
    private final ApostaRepository apostaRepository;


    public ApostaOut salvaAposta(ApostaIn apostaIn){
        Optional<Apostador> apostador = apostadorRepository.findById(apostaIn.getIdApostador());
        String numAposta = UUID.randomUUID().toString();
        Aposta aposta = new Aposta(numAposta, apostador.get());

        apostaRepository.save(aposta);
        return new ApostaOut(numAposta, apostador.get().getName(), apostador.get().getEmail());
    }
}
