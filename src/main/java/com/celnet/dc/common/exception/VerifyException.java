package com.celnet.dc.common.exception;

/**
 * Created by Mike on 2017/6/22.
 */
public class VerifyException extends Exception{
    private ErrorInfo errorInfo;

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public VerifyException(ErrorInfo errorInfo){
        super(errorInfo.getMessage());
        this.errorInfo = errorInfo;
    }
}
