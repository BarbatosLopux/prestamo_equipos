package com.gestion.domain.repository;


import com.gestion.pesistence.entity.Computador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ComputadorRepository extends JpaRepository<Computador, String> {
    @Modifying
    @Query("UPDATE Computador c SET c.equipoActivo = :estado WHERE c.serialComputador = :serial")
    void modificarEstadoComputador(@Param("serial") String serial, @Param("estado") boolean estado);
}
