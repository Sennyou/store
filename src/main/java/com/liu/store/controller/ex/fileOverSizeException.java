package com.liu.store.controller.ex;
//文件过大异常
public class fileOverSizeException extends fileUploadException{
    public fileOverSizeException() {
        super();
    }

    public fileOverSizeException(String message) {
        super(message);
    }

    public fileOverSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public fileOverSizeException(Throwable cause) {
        super(cause);
    }

    protected fileOverSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
