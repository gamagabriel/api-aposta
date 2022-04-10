package com.api.bet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class BetController {

    private final ApostadorRepository apostadorRepository;

    public BetController(ApostadorRepository apostadorRepository) {
        this.apostadorRepository = apostadorRepository;
    }

    @PostMapping("/apostador")
    public ResponseEntity saveBet(@RequestBody ApostadorIn apostadorIn){
        Apostador apostador = apostadorIn.toConvert();
        apostadorRepository.save(apostador);
        return ResponseEntity.status(CREATED).build();
    }
}
