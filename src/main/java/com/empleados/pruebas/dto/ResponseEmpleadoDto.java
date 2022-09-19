package com.empleados.pruebas.dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseEmpleadoDto {

	
	private String nombres;
	
	private String apellidos;

	private String tipo_de_documento;

	private String numero_de_documento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fecha_de_nacimiento;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fecha_vinculacion_compania;
	
	private String cargo;
	
	private Double salario;
	
	private String tiempo_vinculacion_compania;
	
	private String edad_empleado;


}
