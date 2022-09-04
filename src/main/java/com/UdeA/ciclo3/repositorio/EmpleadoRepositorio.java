package com.UdeA.ciclo3.repositorio;

import com.UdeA.ciclo3.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository <Empleado, Long>{
}

