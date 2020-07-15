package com.step.ap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoAuthException extends ResponseStatusException {
    public NoAuthException() {
        super(HttpStatus.FORBIDDEN, "无权限");
    }
}
