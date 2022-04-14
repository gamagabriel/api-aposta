package com.api.bet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ApostaOut {

    private String numeroAposta;
    private String nomeApostador;
    private String emailApostador;

}
