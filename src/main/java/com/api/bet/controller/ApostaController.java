package com.api.bet.controller;

import com.api.bet.model.dto.ApostaIn;
import com.api.bet.service.ApostaService;
import com.api.bet.service.ApostadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class ApostaController {

    private final ApostaService apostaService;

    @PostMapping("/aposta")
    public ResponseEntity salvaAposta(@RequestBody ApostaIn apostaIn){
        System.out.println("IdApostador: " + apostaIn.getIdApostador());
        return ResponseEntity.status(CREATED).build();
    }
}
