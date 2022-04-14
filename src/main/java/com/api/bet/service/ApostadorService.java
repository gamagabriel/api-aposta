package com.api.bet.service;

import com.api.bet.model.Apostador;
import com.api.bet.model.dto.ApostadorIn;
import com.api.bet.repository.ApostadorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ApostadorService {

    private final ApostadorRepository apostadorRepository;
    private final ModelMapper modelMapper;

    public void salvaApostador(ApostadorIn apostadorIn){
        Apostador apostador = modelMapper.map(apostadorIn, Apostador.class);
        apostadorRepository.save(apostador);
    }

    public void delete(Long id){
        try{
            apostadorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new NotFoundException(e.getMessage());
        }
    }

    public List<Apostador> findAll() {
        return apostadorRepository.findAll();
    }
}
