package com.wcyc.base.common.exception;


import com.wcyc.base.api.base.entity.ReturnDTO;
import com.wcyc.base.common.enums.HttpCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 公共 业务 异常类
 */
public class WcycException extends RuntimeException {

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected String error;
    protected int code;
    protected ReturnDTO returnDTO;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ReturnDTO getReturnDTO() {
        return returnDTO;
    }

    public void setReturnDTO(ReturnDTO returnDTO) {
        this.returnDTO = returnDTO;
    }

    public WcycException(ReturnDTO returnDTO) {
        super(returnDTO.getError());
        this.returnDTO = returnDTO;
    }

    public WcycException(String error) {
        super(error);
        this.code = HttpCodeEnum.UN_KNOW_ERROR.getCode();
        this.error = error;
        this.returnDTO = new ReturnDTO(code, error);
    }

    public WcycException(int code, String error) {
        super(error);
        this.code = code;
        this.error = error;
        this.returnDTO = new ReturnDTO(code, error);
    }

    public WcycException(HttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMessage());
        this.code = httpCodeEnum.getCode();
        this.error = httpCodeEnum.getMessage();
        this.returnDTO = new ReturnDTO(code, error);
    }
}
