package com.interseguro.core.exception;

import com.interseguro.core.utils.GenericError;

import java.io.Serializable;

public class InterseguroException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -123456789L;
    private final String code;

    public InterseguroException(GenericError error, String message, Throwable cause) {
        super(message, cause);
        this.code = error.getCode();
    }

    public InterseguroException(GenericError error, String message) {
        super(message);
        this.code = error.getCode();
    }

    public InterseguroException(GenericError error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public String getCode() {
        return code;
    }
}
