package com.empleados.pruebas.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDto {
	@NotNull(message = "El parametro nombre no puede ser nulo")
	@NotEmpty(message = "El parametro nombre no puede ser vacio")
	private String nombres;
	@NotNull(message = "El parametro apellido no puede ser nulo")
	@NotEmpty(message = "El parametro apellido no puede ser vacio")
	private String apellidos;
	@NotNull(message = "El parametro  tipo de documento no puede ser nulo")
	@NotEmpty(message = "El parametro tipo de documento no puede ser vacio")
	private String tipo_de_documento;
	@NotNull(message = "El parametro numero de documento no puede ser nulo")
	@NotEmpty(message = "El parametro numero de documento no puede ser vacio")
	private String numero_de_documento;
	@NotNull(message = "El parametro fecha de nacimiento no puede ser nulo")
	@NotEmpty(message = "El parametro fecha de nacimiento  no puede ser vacio")
	private String fecha_de_nacimiento;
	@NotNull(message = "El parametro fecha vinculación compañía no puede ser nulo")
	@NotEmpty(message = "El parametro fecha vinculación compañía no puede ser vacio")
	private String fecha_vinculación_compañía;
	@NotNull(message = "El parametro cargo no puede ser nulo")
	@NotEmpty(message = "El parametro cargo no puede ser vacio")
	private String cargo;
	private Double salario;
	

	

}
