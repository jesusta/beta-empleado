package com.empleados.pruebas.service;

import com.empleados.pruebas.dao.EmpleadoDAO;
import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class EmpleadoServiceImplTest {
    @InjectMocks
    private EmpleadoServiceImpl empleadoServiceImpl;

    @Mock
    private EmpleadoDAO empleadoDAO;
    private EmpleadoEntity empleadoEntity;
    private EmpleadoDto empleadoDto;

    @BeforeEach
    void setUp() {

        empleadoEntity=new EmpleadoEntity();
        empleadoEntity.setNombres("juan");
        empleadoEntity.setApellidos("fasssss");
        empleadoEntity.setTipo_de_documento("cc");
        empleadoEntity.setNumero_de_documento("1000233");
        empleadoEntity.setFecha_de_nacimiento(new Date(12314443));

        empleadoEntity.setCargo("ing");
        empleadoEntity.setSalario(10000d);
        empleadoDto=new EmpleadoDto();
        empleadoDto.setNombres("juan");
        empleadoDto.setApellidos("fasssss");
        empleadoDto.setTipo_de_documento("cc");
        empleadoDto.setNumero_de_documento("1000233");
        empleadoDto.setFecha_de_nacimiento("03/02/2001");
        empleadoDto.setFecha_vinculación_compañía("03/02/2020");
        empleadoDto.setCargo("ing");
        empleadoDto.setSalario(10000d);
    }

    @Test
    void save() {

    when(empleadoDAO.save(any(EmpleadoEntity.class))).thenReturn(empleadoEntity);

       EmpleadoEntity empleadoEntity1=empleadoServiceImpl.save(empleadoDto);

       Assertions.assertNotNull(empleadoEntity1);
        verify(empleadoDAO).save(any(EmpleadoEntity.class));
    }
}