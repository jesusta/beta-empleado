package com.empleados.pruebas.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.pruebas.dao.EmpleadoDAO;
import com.empleados.pruebas.dao.EmpleadoDAOImpl;
import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoDAO empleadoDAO;
	
	@Override
	public EmpleadoEntity save(EmpleadoDto empleadoDto) {
		EmpleadoEntity empleadoEntity=new EmpleadoEntity();
		empleadoEntity.setNombres(empleadoDto.getNombres());
		
		empleadoEntity.setApellidos(empleadoDto.getApellidos());
		empleadoEntity.setTipo_de_documento(empleadoDto.getTipo_de_documento());
		empleadoEntity.setNumero_de_documento(empleadoDto.getNumero_de_documento());
		try {
			empleadoEntity.setFecha_de_nacimiento( new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(empleadoDto.getFecha_de_nacimiento()).getTime()));
			empleadoEntity.setFecha_vinculacion_compania(new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(empleadoDto.getFecha_vinculación_compañía()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empleadoEntity.setCargo(empleadoDto.getCargo());
		
		empleadoEntity.setSalario(empleadoDto.getSalario());
		
		EmpleadoEntity emple=  empleadoDAO.save(empleadoEntity);
			

	
		return emple;
	}

}
