package com.api.bet.model.dto;

import com.api.bet.model.Apostador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aposta {

    @Id
    private String numeroAposta;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Apostador apostador;
}
