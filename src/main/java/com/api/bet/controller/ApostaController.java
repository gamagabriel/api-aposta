package com.api.bet.controller;

import com.api.bet.model.dto.ApostadorIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ApostaController {


    @PostMapping("/aposta")
    public ResponseEntity salvaAposta(@RequestBody ApostadorIn apostadorIn){

        return ResponseEntity.status(CREATED).build();
    }
}
