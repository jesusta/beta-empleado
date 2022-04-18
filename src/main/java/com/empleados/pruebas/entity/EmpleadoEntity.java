package com.empleados.pruebas.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JSpinner.DateEditor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombres;

	private String apellidos;
	
	private String tipo_de_documento;

	private String numero_de_documento;

	private Date fecha_de_nacimiento;

	private Date fecha_vinculacion_compania;
	private String cargo;

	private Double salario;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

}
