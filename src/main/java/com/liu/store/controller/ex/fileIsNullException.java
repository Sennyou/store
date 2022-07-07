package com.liu.store.controller.ex;
//文件为空异常
public class fileIsNullException extends fileUploadException{
    public fileIsNullException() {
        super();
    }

    public fileIsNullException(String message) {
        super(message);
    }

    public fileIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public fileIsNullException(Throwable cause) {
        super(cause);
    }

    protected fileIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
