package com.gestion.domain.repository;
import com.gestion.pesistence.entity.Marca;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
  @Query("SELECT m FROM Marca m WHERE lower(trim(m.nombreMarca)) = :nombreMarca")
  List<Marca> mapeoNombreMarca(@Param("nombreMarca") String nombreMarca);
}
