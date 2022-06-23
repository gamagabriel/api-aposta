package com.api.bet.model.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApostadorIn {

    @NotBlank(message = "O nome do Apostador não pode estar em branco")
    private String name;

    @NotBlank(message = "O email do Apostador não pode estar em branco")
    @Email(message = "Por favor, preencha o campo com um email válido.")
    private String email;

}

