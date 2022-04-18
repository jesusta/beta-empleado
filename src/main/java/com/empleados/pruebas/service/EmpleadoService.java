package com.empleados.pruebas.service;

import java.text.ParseException;

import com.empleados.pruebas.dao.EmpleadoDAO;
import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;

public interface EmpleadoService {

	public EmpleadoEntity save(EmpleadoDto empleadoDto) ;
	
}
