package com.gestion.domain.repository;


import com.gestion.pesistence.entity.Computador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComputadorRepository extends JpaRepository<Computador, String> {
}
