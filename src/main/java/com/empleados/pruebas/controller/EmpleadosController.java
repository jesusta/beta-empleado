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

import com.empleados.pruebas.exception.InvalidDataException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.dto.ResponseEmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;

import com.empleados.pruebas.service.EmpleadoService;


@RestController
@RequestMapping("/empleados")
@Api(value = "Servicios asociados a la gestión de empleados")
@ApiOperation(value = "Servicios asociados a la gestión de empleados")
public class EmpleadosController {

	@Autowired
	EmpleadoService empleadoService;

	@PostMapping("/guardar")
	@ApiOperation(value = "Crear un empleado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Empleados creada correctamente", response = Map.class) })
	public ResponseEntity<?> guardar(@Valid @RequestBody EmpleadoDto empleadoDto, BindingResult bindingResult)
			throws Exception {

		Map<String, Object> response = new HashMap<>();
		if (bindingResult.hasErrors()) {
			throw  new InvalidDataException(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.parse(empleadoDto.getFecha_de_nacimiento());
			formatoFecha.parse(empleadoDto.getFecha_vinculación_compañía());
		} catch (ParseException e) {
			throw  new InvalidDataException( "Las fechas de nacimiento y de viculacion deben estar en el formato dd/MM/yyyy");
			
		}
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimiento =  LocalDate.parse(empleadoDto.getFecha_de_nacimiento(),formato);
		Period period = Period.between(fechaNacimiento, LocalDate.parse(LocalDate.now().toString()));
		LocalDate viculacionEmpresa = LocalDate.parse(empleadoDto.getFecha_vinculación_compañía(),formato);;
		if (period.getYears() <= 17) {
			throw  new InvalidDataException(
					"No se puede guardar el empleado es menor de edad, la edad es :" + period.getYears()+" años");
			
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
	@GetMapping("find/{id}")
	@ApiOperation(value = "Buscar un empleado")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Empleado Buscado correctamente", response = Map.class) })
	public EmpleadoEntity fingId(@PathVariable Long id){
		return empleadoService.findId(id);
	}
	@GetMapping("find")
	@ApiOperation(value = "Buscar empleados")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Empleadso Buscado correctamente", response = Map.class) })
	public List<EmpleadoEntity> findEmpleados(){
		return empleadoService.findEmpleados();
	}

}
