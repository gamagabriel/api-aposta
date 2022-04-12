package com.api.bet.service;

import com.api.bet.model.Apostador;
import com.api.bet.model.dto.Aposta;
import com.api.bet.model.dto.ApostaIn;
import com.api.bet.model.dto.ApostaOut;
import com.api.bet.repository.ApostaRepository;
import com.api.bet.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApostaService {

    private final ApostadorRepository apostadorRepository;
    private final ApostaRepository apostaRepository;

    ApostaOut apostaOut = null;

    public ApostaOut salvaAposta(ApostaIn apostaIn){

        try{
            Optional<Apostador> apostador = apostadorRepository.findById(apostaIn.getIdApostador());
            String numAposta = UUID.randomUUID().toString();
            Aposta aposta = new Aposta(numAposta, apostador.get());

            apostaRepository.save(aposta);
            apostaOut = new ApostaOut(numAposta, apostador.get().getName(), apostador.get().getEmail());
        }catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        return apostaOut;
    }
}
