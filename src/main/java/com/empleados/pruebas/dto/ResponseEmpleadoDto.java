package com.empleados.pruebas.dto;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;


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

	public Date getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public Date getFecha_vinculacion_compania() {
		return fecha_vinculacion_compania;
	}

	public void setFecha_vinculacion_compania(Date fecha_vinculacion_compania) {
		this.fecha_vinculacion_compania = fecha_vinculacion_compania;
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

	public String getTiempo_vinculacion_compania() {
		return tiempo_vinculacion_compania;
	}

	public void setTiempo_vinculacion_compania(String tiempo_vinculacion_compania) {
		this.tiempo_vinculacion_compania = tiempo_vinculacion_compania;
	}

	public String getEdad_empleado() {
		return edad_empleado;
	}

	public void setEdad_empleado(String edad_empleado) {
		this.edad_empleado = edad_empleado;
	}

}
