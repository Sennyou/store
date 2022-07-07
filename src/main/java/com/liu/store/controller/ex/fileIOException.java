package com.liu.store.controller.ex;
//文件IO异常
public class fileIOException extends fileUploadException{
    public fileIOException() {
        super();
    }

    public fileIOException(String message) {
        super(message);
    }

    public fileIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public fileIOException(Throwable cause) {
        super(cause);
    }

    protected fileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
