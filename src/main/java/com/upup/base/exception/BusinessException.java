package com.upup.base.exception;

import com.upup.base.util.ResponseStatus;

public class BusinessException extends RuntimeException {
    public BusinessException(ResponseStatus status209) {
    }

    public BusinessException(String message) {
        super(message);
    }
}
