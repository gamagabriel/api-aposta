package com.api.bet.controller;

import com.api.bet.model.dto.Aposta;
import com.api.bet.model.dto.ApostaIn;
import com.api.bet.model.dto.ApostaOut;
import com.api.bet.model.dto.ApostasOut;
import com.api.bet.service.ApostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class ApostaController {

    private final ApostaService apostaService;

    @PostMapping("/aposta")
    public ResponseEntity<ApostaOut> salvaAposta(@Valid @RequestBody ApostaIn apostaIn) {
        ApostaOut apostaOut = apostaService.salvaAposta(apostaIn);

        return ResponseEntity.status(CREATED).body(apostaOut);
    }

    @GetMapping("/read-all-apostas")
    public List<Aposta> findAll() {
        return apostaService.findAll();
    }

    @GetMapping("/getaposta/{id}")
    public List <ApostasOut> apostaById(@PathVariable Long id) {
        return apostaService.apostaById(id);
    }
}
