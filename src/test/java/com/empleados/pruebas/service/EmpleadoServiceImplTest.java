package com.empleados.pruebas.service;

import com.empleados.pruebas.dao.EmpleadoDAO;
import com.empleados.pruebas.data.FactoryEmpleadoTestData;
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

import java.util.List;
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


    @BeforeEach
    void setUp() {


    }

    @Test
    void save() {
        EmpleadoEntity empleadoEntity = FactoryEmpleadoTestData.getEmpleadoEntity();
        when(empleadoDAO.save(any(EmpleadoEntity.class))).thenReturn(empleadoEntity);
        EmpleadoDto empleadoDto = FactoryEmpleadoTestData.getEmpleadoDto();
        EmpleadoEntity empleadoEntity1 = empleadoServiceImpl.save(empleadoDto);

        Assertions.assertNotNull(empleadoEntity1);
        verify(empleadoDAO).save(any(EmpleadoEntity.class));
    }

    @Test
    void buscarEmpleadoporId() {
        EmpleadoEntity empleadoEntity = FactoryEmpleadoTestData.getEmpleadoEntity();
        Optional<EmpleadoEntity> empleadoEntity1 = Optional.of(FactoryEmpleadoTestData.getEmpleadoEntity());

        when(empleadoDAO.findById(any(Long.class))).thenReturn(empleadoEntity1);

        empleadoEntity = empleadoServiceImpl.findId(1L);
        Assertions.assertNotNull(empleadoEntity);
        Assertions.assertEquals(1L, empleadoEntity.getId());

    }

    @Test
    void BuscarTodo() {
        List<EmpleadoEntity> empleadoEntity = List.of(FactoryEmpleadoTestData.getEmpleadoEntity());
        when(empleadoDAO.findAll()).thenReturn(empleadoEntity);
        List<EmpleadoEntity> empleadoEntityList = empleadoServiceImpl.findEmpleados();
        Assertions.assertNotNull(empleadoEntityList);

    }
}