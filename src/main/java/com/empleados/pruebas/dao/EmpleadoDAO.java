package com.empleados.pruebas.dao;

import com.empleados.pruebas.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoDAO extends JpaRepository<EmpleadoEntity, Long> {
}
