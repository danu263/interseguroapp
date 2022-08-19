package com.interseguro.core.utils.impl;

import com.interseguro.core.utils.GenericError;

public enum GenericErrorEnum implements GenericError {

    ER0000("GEN00000", "Unknown error encountered"),
    ER0001("GEN00001", "Parameter sent is null."),

    // errors for matrix service
    MT0000("MT00000", "Matrix has no values."),
    MT0001("MT00001", "Matrix is not symmetric(NxN).");

    GenericErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
