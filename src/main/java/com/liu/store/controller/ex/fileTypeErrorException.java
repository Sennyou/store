package com.liu.store.controller.ex;
//文件类型错误异常
public class fileTypeErrorException extends fileUploadException{
    public fileTypeErrorException() {
        super();
    }

    public fileTypeErrorException(String message) {
        super(message);
    }

    public fileTypeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public fileTypeErrorException(Throwable cause) {
        super(cause);
    }

    protected fileTypeErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
