package com.liu.store.controller.ex;
//文件上传异常的基类
public class fileUploadException extends RuntimeException{
    public fileUploadException() {
        super();
    }

    public fileUploadException(String message) {
        super(message);
    }

    public fileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public fileUploadException(Throwable cause) {
        super(cause);
    }

    protected fileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
