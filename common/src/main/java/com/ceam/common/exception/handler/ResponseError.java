package com.ceam.common.exception.handler;

import cn.hutool.http.HttpStatus;
import lombok.Data;

/**
 * @author CeaM
 * 2023/01/27 10:53
 **/
@Data
public class ResponseError {

    private Integer status  = HttpStatus.HTTP_BAD_REQUEST;
    private String msg;

    public static ResponseError error(String msg) {
        ResponseError responseError = new ResponseError();
        responseError.msg = msg;
        return responseError;
    }

    public static ResponseError error(Integer status, String msg) {
        ResponseError responseError = new ResponseError();
        responseError.status = status;
        responseError.msg = msg;
        return responseError;
    }

}
