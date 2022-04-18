package com.empleados.pruebas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.pruebas.dao.EmpleadoDAO;
import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.dto.ResponseEmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;

import com.empleados.pruebas.service.EmpleadoService;
import com.empleados.pruebas.service.EmpleadoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

	@Autowired
	EmpleadoService empleadoService;

	@PostMapping("/guardar")
	public ResponseEntity<?> guardar(@Valid @RequestBody EmpleadoDto empleadoDto, BindingResult bindingResult)
			throws Exception {

		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {

			List<String> errors = bindingResult.getFieldErrors().stream().map(err -> err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.parse(empleadoDto.getFecha_de_nacimiento());
			formatoFecha.parse(empleadoDto.getFecha_vinculación_compañía());
		} catch (ParseException e) {
			response.put("errors", "Las fechas de nacimiento y de viculacion deben estar en el formato dd/MM/yyyy");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate fechaNacimiento =  LocalDate.parse(empleadoDto.getFecha_de_nacimiento(),formato);
		

		Period period = Period.between(fechaNacimiento, LocalDate.parse(LocalDate.now().toString()));
		LocalDate viculacionEmpresa = LocalDate.parse(empleadoDto.getFecha_vinculación_compañía(),formato);;
		if (period.getYears() <= 17) {
			response.put("errors",
					"No se puede guardar el empleado es menor de edad, la edad es :" + period.getYears()+" años");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		
		EmpleadoEntity emp = empleadoService.save(empleadoDto);
		
		
		Period period2 = Period.between(viculacionEmpresa, LocalDate.parse(LocalDate.now().toString()));

		ResponseEmpleadoDto responseEmpleadoDto = new ResponseEmpleadoDto();

		responseEmpleadoDto.setNombres(emp.getNombres());
		responseEmpleadoDto.setApellidos(emp.getApellidos());
		responseEmpleadoDto.setTipo_de_documento(emp.getTipo_de_documento());
		responseEmpleadoDto.setNumero_de_documento(emp.getNumero_de_documento());
		responseEmpleadoDto.setFecha_de_nacimiento(emp.getFecha_de_nacimiento());
		responseEmpleadoDto.setCargo(emp.getCargo());
		responseEmpleadoDto.setFecha_vinculacion_compania(emp.getFecha_vinculacion_compania());
		responseEmpleadoDto.setSalario(emp.getSalario());
		responseEmpleadoDto.setTiempo_vinculacion_compania(period2.getYears() + " años, " + period2.getMonths() + " meses ");
		responseEmpleadoDto.setEdad_empleado(
				period.getYears() + " años, " + period.getMonths() + " meses ," + period.getDays() + " dias");

		
		response.put("Empleado", responseEmpleadoDto);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
