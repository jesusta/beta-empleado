package com.empleados.pruebas.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empleados.pruebas.entity.EmpleadoEntity;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO{

	@Autowired
    private EntityManager entityManager;

	
	@Override
	@Transactional
	public EmpleadoEntity save(EmpleadoEntity empleado) {
		// TODO Auto-generated method stub
		EmpleadoEntity emp=entityManager.merge(empleado);
		return emp;
	}

}
