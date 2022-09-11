package com.empleados.pruebas.exception;

public class NotFountIDException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFountIDException(String message) {
        super(message);
    }
}
