package com.empleados.pruebas.service;

import java.text.ParseException;
import java.util.List;

import com.empleados.pruebas.dao.EmpleadoDAO;
import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;

public interface EmpleadoService {

	public EmpleadoEntity save(EmpleadoDto empleadoDto) ;

    public EmpleadoEntity findId(Long id);

    public List<EmpleadoEntity> findEmpleados();

}
