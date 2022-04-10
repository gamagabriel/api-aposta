package com.api.bet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ApostadorIn {

    private String name;
    private String email;

    public Apostador toConvert(){
        return new Apostador(name, email);
    }
}

