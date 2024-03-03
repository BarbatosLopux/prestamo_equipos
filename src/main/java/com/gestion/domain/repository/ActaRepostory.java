package com.gestion.domain.repository;

import com.gestion.pesistence.entity.Acta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActaRepostory extends JpaRepository<Acta, Long> {
}
