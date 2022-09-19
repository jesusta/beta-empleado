package com.empleados.pruebas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorInfor {

    private int status;
    private String  message;
    private String timestamp = LocalDateTime.now().toString();
    private String errors;

    ErrorInfor(String message){
        this.message=message;
    }

}
