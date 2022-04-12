package com.api.bet.model.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApostadorIn {

    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;

}

