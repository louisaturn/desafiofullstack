package com.louise.desafiofullstack.service.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private HttpStatus status;
    private String message;

    public StandardError(){
        super();
    }
    public StandardError(Long timestamp, HttpStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = HttpStatus.valueOf(status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
