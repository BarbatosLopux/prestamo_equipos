package com.gestion.domain.repository;
import com.gestion.pesistence.entity.Empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    @Modifying
    @Query("UPDATE Empleado e SET e.estadoEmpleado = :estado WHERE e.dniEmpleado = :dni")
    void modificarEstadoEmpleado(@Param("dni") Long dni, @Param("estado") Integer estado);

}
