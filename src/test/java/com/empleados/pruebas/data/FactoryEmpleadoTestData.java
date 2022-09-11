package com.empleados.pruebas.data;
import com.empleados.pruebas.dto.EmpleadoDto;
import com.empleados.pruebas.entity.EmpleadoEntity;

import java.sql.Date;

public class FactoryEmpleadoTestData {
    public static EmpleadoEntity getEmpleadoEntity(){
        EmpleadoEntity empleadoEntity;
        empleadoEntity=new EmpleadoEntity();
        empleadoEntity.setId(1l);
        empleadoEntity.setNombres("juan");
        empleadoEntity.setApellidos("fasssss");
        empleadoEntity.setTipo_de_documento("cc");
        empleadoEntity.setNumero_de_documento("1000233");
        empleadoEntity.setFecha_de_nacimiento(new Date(12314443));

        empleadoEntity.setCargo("ing");
        empleadoEntity.setSalario(10000d);
        return empleadoEntity;
    }
    public static EmpleadoDto getEmpleadoDto(){
        EmpleadoDto empleadoDto;
        empleadoDto=new EmpleadoDto();
        empleadoDto.setNombres("juan");
        empleadoDto.setApellidos("fasssss");
        empleadoDto.setTipo_de_documento("cc");
        empleadoDto.setNumero_de_documento("1000233");
        empleadoDto.setFecha_de_nacimiento("03/02/2001");
        empleadoDto.setFecha_vinculación_compañía("03/02/2020");
        empleadoDto.setCargo("ing");
        empleadoDto.setSalario(10000d);
        return empleadoDto;
    }
}
