package com.api.bet.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class ApostaIn {

    @NotNull(message = "ID não encontrado. Por favor, verifique o número e tente novamente.")
    private Long idApostador;

}
