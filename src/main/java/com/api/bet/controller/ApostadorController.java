package com.api.bet.controller;

import com.api.bet.model.Apostador;
import com.api.bet.model.dto.ApostadorIn;
import com.api.bet.service.ApostadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
public class ApostadorController {

    private final ApostadorService apostadorService;

    @PostMapping("/apostador")
    public ResponseEntity saveBet(@Valid @RequestBody ApostadorIn apostadorIn){
        apostadorService.salvaApostador(apostadorIn);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping("/read-all")
    public List<Apostador> findAll(){
        return apostadorService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){apostadorService.delete(id);}
}
