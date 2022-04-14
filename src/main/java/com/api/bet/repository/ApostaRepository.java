package com.api.bet.repository;

import com.api.bet.model.dto.Aposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {
    @Query(value = "SELECT * FROM Aposta WHERE id_apostador = ?", nativeQuery = true)
    List<Aposta> findByApostadorId(@Param("idApostador") Long id);
}
