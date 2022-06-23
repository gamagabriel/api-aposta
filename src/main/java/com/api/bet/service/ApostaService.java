package com.api.bet.service;

import com.api.bet.model.Apostador;
import com.api.bet.model.dto.Aposta;
import com.api.bet.model.dto.ApostaIn;
import com.api.bet.model.dto.ApostaOut;
import com.api.bet.model.dto.ApostasOut;
import com.api.bet.repository.ApostaRepository;
import com.api.bet.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ApostaService {

    private final ApostadorRepository apostadorRepository;
    private final ApostaRepository apostaRepository;


    public ApostaOut salvaAposta(ApostaIn apostaIn) {
        ApostaOut apostaOut = null;
        try {
            Optional<Apostador> apostador = apostadorRepository.findById(apostaIn.getIdApostador());
            String numAposta = UUID.randomUUID().toString();
            Aposta aposta = new Aposta(numAposta, apostador.get());

            apostaRepository.save(aposta);
            apostaOut = new ApostaOut(numAposta, apostador.get().getName(), apostador.get().getEmail());

        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        return apostaOut;
    }

    public List<Aposta> findAll() {
        return apostaRepository.findAll();
    }

    public List<ApostasOut> apostaById(Long id) {
        List<Aposta> aposta = apostaRepository.findByApostadorId(id);
        List<ApostasOut> list = new ArrayList<>();
        aposta.forEach(aposta1 -> {
            ApostasOut out = new ApostasOut();
            out.setApostador(aposta1.getApostador().getId());
            out.setNumeroAposta(aposta1.getNumeroAposta());
            list.add(out);
        });

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return list;
    }
}
