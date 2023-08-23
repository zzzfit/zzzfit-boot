package com.ceam.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author CeaM
 * 2023/01/19 21:05
 **/
@Getter
public class ServiceException extends RuntimeException {

    private Integer status = BAD_REQUEST.value();

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(HttpStatus status, String msg) {
        super(msg);
        this.status = status.value();
    }
}
