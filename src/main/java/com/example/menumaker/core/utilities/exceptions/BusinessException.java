package com.example.menumaker.core.utilities.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class BusinessException extends DataIntegrityViolationException {
    public BusinessException(String msg) {
        super(msg);
    }
}
