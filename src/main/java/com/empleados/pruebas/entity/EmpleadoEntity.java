package com.empleados.pruebas.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;

	private String apellidos;
	
	private String tipo_de_documento;

	private String numero_de_documento;

	private Date fecha_de_nacimiento;

	private Date fecha_vinculacion_compania;
	
	private String cargo;

	private Double salario;

	

}
