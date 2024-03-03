package com.gestion.domain.repository;

import com.gestion.pesistence.entity.Cargo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query("SELECT c FROM Cargo c WHERE lower(c.nombreCargo) = :nombreCargo")
    List<Cargo> mapeoNombreCargo(@Param("nombreCargo") String nombreCargo);
}
