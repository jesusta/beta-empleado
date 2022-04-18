package com.empleados.pruebas.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


public class EmpleadoDto {
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
	
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipo_de_documento() {
		return tipo_de_documento;
	}
	public void setTipo_de_documento(String tipo_de_documento) {
		this.tipo_de_documento = tipo_de_documento;
	}
	public String getNumero_de_documento() {
		return numero_de_documento;
	}
	public void setNumero_de_documento(String numero_de_documento) {
		this.numero_de_documento = numero_de_documento;
	}
	public String getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}
	public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}
	public String getFecha_vinculación_compañía() {
		return fecha_vinculación_compañía;
	}
	public void setFecha_vinculación_compañía(String fecha_vinculación_compañía) {
		this.fecha_vinculación_compañía = fecha_vinculación_compañía;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	

}
