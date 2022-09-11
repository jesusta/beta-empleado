package com.empleados.pruebas.exception;

import com.empleados.pruebas.dto.ErrorInfor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
	protected ResponseEntity<ErrorInfor>handlerException(InvalidDataException exc){
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;

        return builderResponseEntity(httpStatus,exc);
    }
    @ExceptionHandler
    protected ResponseEntity<ErrorInfor>notFountIDException(NotFountIDException exc){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;

        return builderResponseEntity(httpStatus,exc);
    }
    protected ResponseEntity<ErrorInfor> builderResponseEntity(HttpStatus httpStatus , Exception ex
    ){
        ErrorInfor errorInfor = new ErrorInfor();
        errorInfor.setStatus(httpStatus.value());
        errorInfor.setMessage("GOP "+501);
        errorInfor.setErrors(ex.getMessage());
        return new ResponseEntity<ErrorInfor> (errorInfor,httpStatus);
    }

}
